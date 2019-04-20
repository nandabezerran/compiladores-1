package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class ClassDeclarationExtends extends ClassDeclaration {
    public Identifier i;
    public Identifier j;
    public VarDefinitionList vl;
    public MethodDefinitionList ml;

    public ClassDeclarationExtends(Identifier ai, Identifier aj,
                            VarDefinitionList avl, MethodDefinitionList aml) {
        i=ai; j=aj; vl=avl; ml=aml;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}