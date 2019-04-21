package analisador_semantico.syntaxtree;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.visitors.*;

public class IntegerLiteralExpression extends Expression {
	public int i;

	public IntegerLiteralExpression(int i){
		this.i = i;
	}
	
   	public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}