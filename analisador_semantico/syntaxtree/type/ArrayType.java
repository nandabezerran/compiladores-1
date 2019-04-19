package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class ArrayType extends Type {

    public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}