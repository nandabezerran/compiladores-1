package syntaxtree;
import visitor.*;

public class Class extends ClassDeclaration {
    public Identifier identifier1;
    public VarDeclaration varDeclaration ;  
    public MethodDeclaration methodDeclaration;

    public Class(Identifier pIdentifier1, 
                 VarDeclaration pVarDeclaration, MethodDeclaration pMethodDeclaration) {
        identifier1       = pIdentifier1; 
        varDeclaration    = pVarDeclaration; 
        methodDeclaration = pMethodDeclaration;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}