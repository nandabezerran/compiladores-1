package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class TrueExpression extends Expression {
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}