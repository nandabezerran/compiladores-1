package syntaxtree;

public class AssignStatement extends Statement {

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    
    public String toString(){
        return s;
    }
}