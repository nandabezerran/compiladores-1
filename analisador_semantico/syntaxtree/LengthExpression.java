package syntaxtree;
import syntaxtree.*;
//import visitor.*;

public class LengthExpression extends Expression {
	public Expression e1;

	public LengthExpression(Expression e1){
		this.e1 = e1;
	}

    /*public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }*/
}