package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Main extends MainClass {

    public Identifier identifier1, identifier2;
    public Statement statement;

    public MainClass(Identifier pIdentifier1, Identifier pIdentifier2,
                     Statement pStatement) {
        identifier1 = pIdentifier1;
        identifier2 = pIdentifier2;
        statement   = statement;
    }

    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}