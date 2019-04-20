package visitor;

import syntaxtree.*;

public interface TypeVisitor {
  public Type visit(AndExpression n);
  public Type visit(ArrayAssignStatement n);
  public Type visit(ArrayType n);
  public Type visit(AssignStatement n);
  public Type visit(BigExpression n);
  public Type visit(BlockExpression n);
  public Type visit(BlockStatement n);
  public Type visit(BooleanType n);
  public Type visit(Class n);
  public Type visit(ClassDeclaration n);
  public void visit(ClassDeclarationExtends n);
  public Type visit(Expression n);
  public Type visit(FalseExpression n);
  public Type visit(Formal n);
  public Type visit(Goal n);
  public Type visit(Identifier n);
  public Type visit(IdentifierExpression n);
  public Type visit(IdentifierType n);
  public Type visit(IfStatement n);
  public Type visit(IntegerLiteralExpression n);
  public Type visit(IntegerType n);
  public Type visit(LengthExpression n);
  public Type visit(LessExpression n);
  public Type visit(ListExpression n);
  public Type visit(Main n);
  public Type visit(MainClass n);
  public Type visit(MethodDeclaration n);
  public Type visit(MethodDefinition n);
  public Type visit(MinusExpression n);
  public Type visit(MultExpression n);
  public Type visit(NewIdentifierExpression n);
  public Type visit(NewIntegerExpression n);
  public Type visit(NotExpression n);
  public Type visit(PlusExpression n);
  public Type visit(PrintStatement n);
  public Type visit(Program n);
  public Type visit(Statement n);
  public Type visit(ThisExpression n);
  public Type visit(TrueExpression n);
  public Type visit(Type n);
  public Type visit(VarDeclaration n);
  public Type visit(VarDefinition n);
  public Type visit(WhileStatement n);
}