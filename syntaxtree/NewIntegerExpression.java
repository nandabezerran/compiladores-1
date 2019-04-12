package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class NewIntegerExpression extends Expression {

	public Expression e1;

	public NewIntegerExpression(Expression e1){
		this.e1 = e1;
	} 

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}