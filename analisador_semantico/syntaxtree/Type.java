package analisador_semantico.syntaxtree;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.visitors.*;

public abstract class Type {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeVisitor v);
}