package syntaxtree;

public class NewIdentifierExpression extends Expression {

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    
    public String toString(){
        return s;
    }
}