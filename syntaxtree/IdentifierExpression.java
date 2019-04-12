package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class IdentifierExpression extends Expression {

	public String s;

	public IdentifierExpression(String s){
		this.s = s;
	}

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}