package visitor;

import syntaxtree.*;

public class TypeDepthFirstVisitor implements TypeVisitor {

  // MainClass m;
  // ClassDeclList cl;
  public Type visit(Program n) {
    n.m.accept(this);
    for ( int i = 0; i < n.cl.size(); i++ ) {
        n.cl.elementAt(i).accept(this);
    }
    return null;
  }
  
  // Identifier i1,i2;
  // Statement s;
  public Type visit(Main n) {
    n.i1.accept(this);
    n.i2.accept(this);
    n.s.accept(this);
    return null;
  }
  
  // Identifier i;
  // VarDeclList vl;
  // MethodDeclList ml;
  public Type visit(Class n) {
    n.i.accept(this);
    for ( int i = 0; i < n.vl.size(); i++ ) {
        n.vl.elementAt(i).accept(this);
    }
    for ( int i = 0; i < n.ml.size(); i++ ) {
        n.ml.elementAt(i).accept(this);
    }
    return null;
  }
 
  // Identifier i;
  // Identifier j;
  // VarDeclList vl;
  // MethodDeclList ml;
  public Type visit(ClassDeclarationExtends n) {
    n.i.accept(this);
    n.j.accept(this);
    for ( int i = 0; i < n.vl.size(); i++ ) {
        n.vl.elementAt(i).accept(this);
    }
    for ( int i = 0; i < n.ml.size(); i++ ) {
        n.ml.elementAt(i).accept(this);
    }
    return null;
  }

  // Type t;
  // Identifier i;
  public Type visit(VarDefinition n) {
    n.t.accept(this);
    n.i.accept(this);
    return null;
  }

  // Type t;
  // Identifier i;
  // FormalList fl;
  // VarDeclList vl;
  // StatementList sl;
  // Exp e;
  public Type visit(MethodDefinition n) {
    n.type.accept(this);
    n.identifier.accept(this);
    for ( int i = 0; i < n.formalList.size(); i++ ) {
        n.fl.elementAt(i).accept(this);
    }
    for ( int i = 0; i < n.varDefinitionList.size(); i++ ) {
        n.vl.elementAt(i).accept(this);
    }
    for ( int i = 0; i < n.statementList.size(); i++ ) {
        n.sl.elementAt(i).accept(this);
    }
    n.expression.accept(this);
    return null;
  }

  // Type t;
  // Identifier i;
  public Type visit(Formal n) {
    n.t.accept(this);
    n.i.accept(this);
    return null;
  }

  public Type visit(ArrayType n) {
    return null;
  }

  public Type visit(BooleanType n) {
    return null;
  }

  public Type visit(IntegerType n) {
    return null;
  }

  // String s;
  public Type visit(IdentifierType n) {
    return null;
  }

  // StatementList sl;
  public Type visit(Block n) {
    for ( int i = 0; i < n.sl.size(); i++ ) {
        n.sl.elementAt(i).accept(this);
    }
    return null;
  }

  // Exp e;
  // Statement s1,s2;
  public Type visit(IfStatement n) {
    n.e.accept(this);
    n.s1.accept(this);
    n.s2.accept(this);
    return null;
  }

  // Exp e;
  // Statement s;
  public Type visit(WhileStatement n) {
    n.e.accept(this);
    n.s.accept(this);
    return null;
  }

  // Exp e;
  public Type visit(PrintStatement n) {
    n.e.accept(this);
    return null;
  }
  
  // Identifier i;
  // Exp e;
  public Type visit(AssignStatement n) {
    n.i.accept(this);
    n.e.accept(this);
    return null;
  }

  // Identifier i;
  // Exp e1,e2;
  public Type visit(ArrayAssignStatement n) {
    n.i.accept(this);
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
  }

  // Exp e1,e2;
  public Type visit(AndExpression n) {
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
  }

  // Exp e1,e2;
  public Type visit(LessExpression n) {
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
  }

  // Exp e1,e2;
  public Type visit(PlusExpression  n) {
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
  }

  // Exp e1,e2;
  public Type visit(MinusExpression n) {
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
  }

  // Exp e1,e2;
  public Type visit(MultExpression n) {
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
  }

  // Exp e1,e2;
  public Type visit(ListExpression n) {
    n.e1.accept(this);
    n.e2.accept(this);
    return null;
  }

  // Exp e;
  public Type visit(LengthExpression n) {
    n.e.accept(this);
    return null;
  }

  // Exp e;
  // Identifier i;
  // ExpList el;
  public Type visit(BigExpression n) {
    n.e.accept(this);
    n.i.accept(this);
    for ( int i = 0; i < n.el.size(); i++ ) {
        n.el.elementAt(i).accept(this);
    }
    return null;
  }

  // int i;
  public Type visit(IntegerLiteralExpression n) {
    return null;
  }

  public Type visit(TrueExpression n) {
    return null;
  }

  public Type visit(FalseExpression n) {
    return null;
  }

  // String s;
  public Type visit(IdentifierExpression n) {
    return null;
  }

  public Type visit(ThisExpression n) {
    return null;
  }

  // Exp e;
  public Type visit(NewIntegerExpression n) {
    n.e.accept(this);
    return null;
  }

  // Identifier i;
  public Type visit(NewIdentifierExpressiont n) {
    return null;
  }

  // Exp e;
  public Type visit(NotExpression n) {
    n.e.accept(this);
    return null;
  }

  // String s;
  public Type visit(Identifier n) {
    return null;
  }
}