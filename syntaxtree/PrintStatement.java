package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class PrintStatement extends Statement {
	Expression e;

	public PrintStatement(Expression e){
		this.e = e;
	}

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}