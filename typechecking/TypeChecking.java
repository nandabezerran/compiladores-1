package typechecking;
import syntaxtree.*;
import visitor.*;
public class TypeChecking implements TypeVisitor {

    private ClassTable currClass;
    private MethodTable currMethod;
    private ProgramTable programTable;
    private Error error;

    public boolean hasError() {
        return error.hasError();
    }

    public TypeChecking(ProgramTable pProgramTable) {
        this.programTable = pProgramTable;
    }

    // Type t;
    // Identifier i;
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