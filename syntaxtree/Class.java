package syntaxtree;

public class Class extends ClassDeclaration {

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    
    public String toString(){
        return s;
    }
}