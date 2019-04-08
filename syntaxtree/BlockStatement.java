package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class BlockStatement extends Statement {
	public Statement s1;

	public BlockStatement(Statement s1){
		this.s1 = s1;
	}

   	public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}