package syntaxtree;
import syntaxtree.*;
//import visitor.*;

public class VarDefinition extends VarDeclaration {
    public Type type;
    public Identifier identifier;
  
    public VarDefinition(Type pType, Identifier pIdentifier) {
        type       = pType;
        identifier = pIdentifier;
    }
    
    /*public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
    */
}