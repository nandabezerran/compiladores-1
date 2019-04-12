package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class LengthExpression extends Expression {

	public Expression e1, e2;

	public LengthExpression(Expression e1, Expression e2){
		this.e1 = e1;
		this.e2 = e2;
	}

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}