package analisador_semantico.syntaxtree;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.visitors.*;

public class ClassSimple extends ClassDeclaration {
    public Identifier identifier1;
    public VarDefinitionList varDeclaration ;  
    public MethodDeclarationList methodDeclaration;

    public ClassSimple(Identifier pIdentifier1, 
    VarDefinitionList pVarDeclaration, MethodDeclarationList pMethodDeclaration) {
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