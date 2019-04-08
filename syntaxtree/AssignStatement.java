package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class AssignStatement extends Statement {
	public Identifier id;
	public Expression e;

	public AssignStatement(Expression e, Identifier id){
		this.e = e;
		this.id = id;
	}

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}