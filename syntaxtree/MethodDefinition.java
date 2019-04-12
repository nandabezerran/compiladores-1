package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class MethodDefinition {
  public Type type;
  public Identifier identifier;
  public FormalList formalList;
  public VarDefinitionList varDefinitionList;
  public StatementList statementList;
  public Expression expression;

  public MethodDecl(Type pType, Identifier pIdentifier, FormalList pFormalList,
                    VarDeclaration pVarDeclaration, StatementList pStatementList,
                    Expression pExpression) {
     type              = pType;
     identifier        = pIdentifier;
     formalList        = pFormalList;
     varDefinitionList = pVarDeclaration;
     statementList     = pStatementList;
     expression        = pExpression;
  }

 
    public abstract void accept(Visitor v) {
        return v.visit(this);
    }

    public abstract Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}