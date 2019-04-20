package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Main extends MainClass {
    public Identifier identifier1, identifier2;
    public Statement statement;

    public Main(Identifier pIdentifier1, Identifier pIdentifier2,
                     Statement pStatement) {
        identifier1 = pIdentifier1;
        identifier2 = pIdentifier2;
        statement = pStatement;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}