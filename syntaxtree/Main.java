package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Main extends MainClass {

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}