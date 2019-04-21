package typechecking;
import syntaxtree.*;
import java.util.*;
import context.*;
import visitor.*;

public class TypeChecking implements TypeVisitor{

    private ClassContext currClass;
    private MethodContext currMethod;
    private MainContext programTable;
    private Error error = new Error();

    public Type visit(Program n){
        n.m.accept(this);
        for (int i = 0; i < n.cl.size(); i++) {
            n.cl.elementAt(i).accept(this);
        }
        return null;
    }

    public void visit(VarDefinition pVarDefinition) {
        Type type = pVarDefinition.type.accept(this);
        String id = pVarDefinition.identifier.toString();
        Symbol symbol = new Symbol(id);
        if (currMethod == null) {
            if (!currClass.addVariavel(type, symbol))
                error.complain(id + "is already defined in " + currClass.getNome());
        } else if (!currMethod.addVar(type, symbol))
            error.complain(id + "is already defined in "
                    + currClass.getNome() + "." + currMethod.getNome());
    }

    public Type visit(AssignStatement pAssignStatement) {
        Type tipo;
        Type exp = pAssignStatement.expressioon.accept(this);

        if ((currMethod != null) ){
            if (currMethod.getVar(Symbol.symbol(pAssignStatement.id.getValue()))!=null) {
                tipo = currMethod.getVars(Symbol.symbol(pAssignStatement.id.getValue()));
                if (exp == null || ! tipo.getTypeClass().equals(exp.getTypeClass())) {
                    error.complain("Os tipos do Assign não são compativeis");
                }
            }
            if (currMethod.getParam(Symbol.symbol(pAssignStatement.id.getValue()))!=null) {
                tipo = currMethod.getParams(Symbol.symbol(pAssignStatement.id.getValue()));
                if (exp == null || ! tipo.getTypeClass().equals(exp.getTypeClass())) {
                    error.complain("Os tipos do Assign não são compativeis");
                }
            }
        }

        if ((currClass != null) && currClass.getVars(Symbol.symbol(pAssignStatement.id.getValue()))!=null) {
            tipo = currClass.getVars(Symbol.symbol(pAssignStatement.id.getValue()));
            if (exp == null || ! tipo.getTypeClass().equals(exp.getTypeClass())) {
                error.complain("Os tipos do Assign não são compativeis");
            }
        }
        if (programTable.getClasses(Symbol.symbol(pAssignStatement.id.getValue())) != null) {
            tipo = new IdentifierType(pAssignStatement.id.getValue());
            ClassTable nomeClasse = mainTable.getClasses(Symbol.symbol( ((IdentifierType) tipo).getValue()));
            if (nomeClasse == null || !nomeClasse.get().equals(exp.getTypeClass()))
                error.complain("Os tipos do Assign não são compativeis");
        }

        return null;
    }


    public Type visit(ArrayAssignStatement pArray) {
        Type var = whatType(pArray.i.toString());
        if (var == null)
            error.complain("Array Type not declared");
        else if (!(var instanceof IntegerType))
            error.complain("Array must be integer");
        if (! (pArray.expression1.accept(this) instanceof IntegerType))
            error.complain("Iterator of Array must be integer");
        if (! (pArray.expression2.accept(this) instanceof IntegerType))
            error.complain("Right side expression of Array Assign must be integer");
        return null;
    }

    public void visit(AssignStatement pAssignStatement) {
        Type identifier = pAssignStatement.identifier.toString();
        Expression expression = pAssignStatement.expression.accept(this);
        if (! (expression instanceof currClass.getType(identifier).toString()))
        error.complain("The assignment can't be done, they dont have the same type");
        return new IntegerType();
    }


    public Type visit(And pAnd) {
        if (! (pAnd.expression1.accept(this) instanceof BooleanType))
            error.complain("Left side of operator && must be boolean");
        if (! (pAnd.expression2.accept(this) instanceof BooleanType))
            error.complain("Right side of operator && must be boolean");
        return new BooleanType();
    }

    public Type visit(LessExpression pLess) {
        if (! (pLess.expression1.accept(this) instanceof IntegerType))
            error.complain("Left side of operator < must be integer");
        if (! (pLess.expression2.accept(this) instanceof IntegerType))
            error.complain("Right side of operator < must be integer");
        return new BooleanType();
    }

    public Type visit(IfStatement pIfStatement) {
        if (! (pIfStatement.e.accept(this) instanceof BooleanType))
            error.complain("If statement condition must be boolean");
        pIfStatement.statement1.accept(this);
        pIfStatement.statement2.accept(this);
        return null;
    }

    public Type visit(WhileStatement pWhileStatement) {
        if (! (pWhileStatement.expression.accept(this) instanceof BooleanType))
            error.complain("While statement condition must be boolean");
        pWhileStatement.statement.accept(this);
        return null;
    }

    public Type visit(PlusExpression pPlus) {
        if (! (pPlus.e1.accept(this) instanceof IntegerType) )
            error.complain("Left side of LessThan must be of type integer");
        if (! (pPlus.e2.accept(this) instanceof IntegerType) )
            error.complain("Right side of LessThan must be of type integer");
        return new IntegerType();
    }

    public Type visit(MinusExpression pMinus) {
        if (! (pMinus.expression1.accept(this) instanceof IntegerType) )
            error.complain("Left side of LessThan must be of type integer");
        if (! (pMinus.expression2.accept(this) instanceof IntegerType) )
            error.complain("Right side of LessThan must be of type integer");
        return new IntegerType();
    }

    public Type visit(MultExpression pMult) {
        if (! (pMult.expression1.accept(this) instanceof IntegerType) )
            error.complain("Left side of LessThan must be of type integer");
        if (! (pMult.expression2.accept(this) instanceof IntegerType) )
            error.complain("Right side of LessThan must be of type integer");
        return new IntegerType();
    }

    public Type visit(IdentifierExpression pIdExpression) {
        Type type = whatType(pIdExpression.statement);
        if (type == null)
            error.complain("Identifier not found");
        return type;
    }

    public Type visit(This n) {
        if (currentClass == null)
            error.complain("Class Environment not found");
        return new IdentifierType(currentClass.toString());
    }

}