package syntaxtree;

public class PrintStatement extends Statement {

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    
    public String toString(){
        return s;
    }
}