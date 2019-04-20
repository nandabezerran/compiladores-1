package syntaxtree;
import syntaxtree.*;
//import visitor.*;

public class IdentifierExpression extends Expression {
	public String s;

	public IdentifierExpression(String s){
		this.s = s;
	}

    /*public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }*/
}