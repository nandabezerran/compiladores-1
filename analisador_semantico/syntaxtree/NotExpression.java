package analisador_semantico.syntaxtree;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.visitors.*;

public class NotExpression extends Expression {
	public Expression e1;

	public NotExpression(Expression e1){
		this.e1 = e1;
	} 

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}