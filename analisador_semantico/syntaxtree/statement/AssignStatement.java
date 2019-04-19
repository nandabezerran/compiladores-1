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

    public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}