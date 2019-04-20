package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class BlockStatement extends Statement {
	public StatementList sl;

	public BlockStatement(StatementLSist sl){
		this.s1 = s1;
	}

   	public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}