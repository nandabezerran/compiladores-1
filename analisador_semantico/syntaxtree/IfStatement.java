package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class IfStatement extends Statement {
	public Expression e;
	public Statement s1, s2;

	public IfStatement(Expression e, Statement s1, Statement s2){
		this.e = e;
		this.s1 = s1;
		this.s2 = s2;
	}

    public void accept(Visitor v) {
			v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}