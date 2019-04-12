package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class NewIdentifierExpression extends Expression {

	public Identifier id;

	public NewIdentifierExpression(Identifier id){
		this.id = id;
	} 

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}