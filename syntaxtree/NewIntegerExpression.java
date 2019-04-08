package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class NewIntegerExpression extends Expression {

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}