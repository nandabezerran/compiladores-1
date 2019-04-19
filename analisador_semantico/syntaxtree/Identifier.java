package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Identifier {

	public String s;

	 public Identifier(String s) { 
    	this.s = s;
  	}

  	public void accept(Visitor v) {
    	v.visit(this);
  	}

  	public Type accept(TypeVisitor v) {
    	return v.visit(this);
  	}

  	public String toString(){
    	return s;
 	 }

   
}