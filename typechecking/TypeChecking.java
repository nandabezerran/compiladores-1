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

    public void visit(AssignStatement pAssignStatement) {
        Type identifier = pAssignStatement.identifier.toString();
        Expression expression = pAssignStatement.e.accept(this);
        if (! (expression instanceof currClass.getType(identifier).toString()))
        error.complain("The assignment can't be done, they dont have the same type");
        return new IntegerType();
    }

    public void visit(MethodDefinition pMethodDefinition){
        Type methodType = pMethodDefinition.type.accept(this);
        Identifier methodId = pMethodDefinition.identifier.toString();
        if (currClass == null) {
            if (!programTable.addVar(methodId, methodType))
                error.complain(id + "is already defined in " + currClass.getId());
        } else if (!currClass.addVar(id, type))
            error.complain(id + "is already defined in "
                    + currClass.getId() + "." + currMethod.getId());

        for ( int i = 0; i < pMethodDefinition.formalList.size(); i++ ) {
            pMethodDefinition.formalList.elementAt(i).visit(this);
        }
        for ( int i = 0; i < n.varDefinitionList.size(); i++ ) {
            pMethodDefinition.varDefinitionList.elementAt(i).visit(this);
        }
        for ( int i = 0; i < n.statementList.size(); i++ ) {
            pMethodDefinition.statementList.elementAt(i).visit(this);
        }
        pMethodDefinition.expression.accept(this);
    }

    public void visit(Class pClass) {
        public VarDeclaration varDeclaration ;
        public MethodDeclaration methodDeclaration;
        VarDeclaration var = pClass.varDeclaration.accept(this);
        VarDeclaration method = pClass.methodDeclaration.accept(this);
        String id1 = pClass.identifier1.toString();
        String id2 = pClass.identifier2.toString();
        //TODO I dont know how we going to do in the table to add classes
        if (!programTable.addVar(id1)) {
            error.complain(id + "is already defined in " + programTable.getId());
        }
        if (!programTable.addVar(id2)) {
            error.complain(id + "is already defined in " + programTable.getId());
        }
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


}