package syntaxtree;
import syntaxtree.*;
// import visitor.*;

public class IdentifierType extends Type {
	public String s;

	public IdentifierType(String s){
		this.s = s;
	}

    /*public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
         return v.visit(this);
    }*/
}