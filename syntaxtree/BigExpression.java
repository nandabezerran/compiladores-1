package syntaxtree;

public class BigExpression extends Expression {

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    
    public String toString(){
        return s;
    }
}