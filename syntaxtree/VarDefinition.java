package syntaxtree;

public class VarDefinition extends VarDeclaration {

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    
    public String toString(){
        return s;
    }
}