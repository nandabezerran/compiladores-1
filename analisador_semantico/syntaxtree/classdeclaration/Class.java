package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Class extends ClassDeclaration {

    public Identifier identifier1;
    public Identifier identifier2;
    public VarDeclaration varDeclaration ;  
    public MethodDeclaration methodDeclaration;

    public Class(Identifier pIdentifier1, Identifier pIdentifier2, 
                 VarDeclaration pVarDeclaration, MethodDeclaration pMethodDeclaration) {
        identifier1       = pIdentifier1; 
        identifier2       = pIdentifier2; 
        varDeclaration    = pVarDeclaration; 
        methodDeclaration = pMethodDeclaration;
    }

    public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}