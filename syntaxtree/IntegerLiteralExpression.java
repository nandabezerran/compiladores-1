package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class IntegerLiteralExpression extends Expression {

	public int i;

	public IntegerLiteralExpression(int i){
		this.i = i;
	}
	
   	public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}