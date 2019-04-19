package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class NewIdentifierExpression extends Expression {

	public Identifier id;

	public NewIdentifierExpression(Identifier id){
		this.id = id;
	} 

    public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}