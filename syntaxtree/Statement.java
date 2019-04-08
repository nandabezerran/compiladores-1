package syntaxtree;

public abstract class Statement {
    public abstract Type accept(TypeVisitor v);
    public abstract Type accept(TypeVisitor v);
}