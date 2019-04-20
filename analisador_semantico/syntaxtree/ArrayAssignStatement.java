package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class ArrayAssignStatement extends Statement {
	public Identifier id;
	public Expression e1, e2;

	public ArrayAssignStatement(Expression e1, Expression e2, Identifier id){
		this. id = id;
		this.e1 = e1;
		this.e2 = e2;
	}

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}