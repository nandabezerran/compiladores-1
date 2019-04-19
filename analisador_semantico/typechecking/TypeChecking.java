package typechecking;
import syntaxtree.*;
import visitor.*;
//The tables aren't defined yet so I assumed that:
//addVar(id, type) -> Adds a variable at the table;
//getVarType(id) -> Returns the type of the variable;
//getVarValue(id) -> Returns the value of the variable;
public class TypeChecking implements TypeVisitor {

    private ClassTable currClass;
    private MethodTable currMethod;
    private ProgramTable programTable;
    private Error error;

    public TypeChecking(ProgramTable pProgramTable) {
        this.programTable = pProgramTable;
    }

    public void visit(VarDefinition pVarDefinition) {
        Type type = pVarDefinition.type.accept(this);
        String id = pVarDefinition.identifier.toString();
        if (currMethod == null) {
            if (!currClass.addVar(id, type))
                error.complain(id + "is already defined in " + currClass.getId());
        } else if (!currMethod.addVar(id, type))
            error.complain(id + "is already defined in "
                    + currClass.getId() + "." + currMethod.getId());
    }

    public Type visit(AssignStatement pAssignStatement) {
        Type var = whatType(pAssignStatement.i.toString());
        Type exp = pAssignStatement.expression.accept(this);
        if (var instanceof IdentifierType) //Class
        {
            ClassTable c = programTable.getClass(Symbol.symbol(((IdentifierType) var).toString()));
            if (c == null || !c.toString().equals(exp.toString()))
                error.complain("Assign types not maching");
        }
        else
        {
            if (var == null || exp == null || !var.toString().equals(exp.toString()))
                error.complain("Assign types not maching");
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
        Expression expression = pAssignStatement.e.accept(this);
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
        if (! (pMinus.e1.accept(this) instanceof IntegerType) )
            error.complain("Left side of LessThan must be of type integer");
        if (! (pMinus.e2.accept(this) instanceof IntegerType) )
            error.complain("Right side of LessThan must be of type integer");
        return new IntegerType();
    }

    public Type visit(MultExpression pMult) {
        if (! (pMult.e1.accept(this) instanceof IntegerType) )
            error.complain("Left side of LessThan must be of type integer");
        if (! (pMult.e2.accept(this) instanceof IntegerType) )
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