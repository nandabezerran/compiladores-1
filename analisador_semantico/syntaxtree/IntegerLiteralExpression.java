package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class IntegerLiteralExpression extends Expression {
	public int i;

	public IntegerLiteralExpression(int i){
		this.i = i;
	}
	
   	public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}