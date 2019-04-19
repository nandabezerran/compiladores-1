package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class VarDefinition extends VarDeclaration {
    public Type type;
    public Identifier identifier;
  
    public VarDecl(Type pType, Identifier pIdentifier) {
        type       = pType;
        identifier = pIdentifier;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}