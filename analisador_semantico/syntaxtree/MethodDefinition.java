//package syntaxtree;
//import visitor.*;

public class MethodDefinition {
  public Type type;
  public Identifier identifier;
  public FormalList formalList;
  public VarDefinitionList varDefinitionList;
  public StatementList statementList;
  public Expression expression;

  public MethodDefinition(Type pType, Identifier pIdentifier, FormalList pFormalList,
                    VarDefinitionList pVarDeclaration, StatementList pStatementList,
                    Expression pExpression) {
     type              = pType;
     identifier        = pIdentifier;
     formalList        = pFormalList;
     varDefinitionList = pVarDeclaration;
     statementList     = pStatementList;
     expression        = pExpression;
  }
 
  /*public void accept(Visitor v) {
    v.visit(this);
  }

  public Type accept(TypeVisitor v) {
    return v.visit(this);
  }*/
}