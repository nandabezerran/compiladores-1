package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class NewIntegerExpression extends Expression {
	public Expression e1;

	public NewIntegerExpression(Expression e1){
		this.e1 = e1;
	} 

    public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}