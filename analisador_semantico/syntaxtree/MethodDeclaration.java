package syntaxtree;
import visitor.*;

public abstract class MethodDeclaration {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}