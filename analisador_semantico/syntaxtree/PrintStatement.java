package analisador_semantico.syntaxtree;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.visitors.*;

public class PrintStatement extends Statement {
	public Expression e;

	public PrintStatement(Expression e){
		this.e = e;
	}

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}