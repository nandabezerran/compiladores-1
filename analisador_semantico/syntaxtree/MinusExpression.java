package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class MinusExpression extends Expression {

	public Expression e1, e2;

	public MinusExpression(Expression e1, Expression e2){
		this.e1 = e1;
		this.e2 = e2;
	}


    public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}