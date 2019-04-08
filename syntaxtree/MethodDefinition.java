package syntaxtree;

public class MethodDefinition extends MethodDeclaration {

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    
    public String toString(){
        return s;
    }
}