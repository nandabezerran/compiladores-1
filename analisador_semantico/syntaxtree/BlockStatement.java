package analisador_semantico.syntaxtree;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.visitors.*;

public class BlockStatement extends Statement {
	public StatementList s1;

	public BlockStatement(StatementList s1){
		this.s1 = s1;
	}

   	public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}