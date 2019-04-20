package syntaxtree;
import visitor.*;

public class WhileStatement extends Statement {
    public Expression e;
    public Statement s1;

    public WhileStatement(Expression e, Statement s1) {
        this.e = e;
        this.s1 = s1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}