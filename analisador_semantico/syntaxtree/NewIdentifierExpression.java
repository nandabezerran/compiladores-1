package analisador_semantico.syntaxtree;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.visitors.*;

public class NewIdentifierExpression extends Expression {
	public Identifier id;

	public NewIdentifierExpression(Identifier id){
		this.id = id;
	} 

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}