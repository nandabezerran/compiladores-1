package visitor;

import java.util.*;
import syntaxtree.*;
import context.*;

public class SymbolTable implements Visitor{
    private MainContext mainContext;
    private ClassContext classe;
    private Method method;
    private ErrorContext error;

    public SymbolTable(){
        mainContext = new MainContext();
        error = new ErrorContext();
        method = null;
        classe = null;
    }

    // Identifier identifier1, identifier2
    // Statement statement
    public void visit(Main n){
        n.identifier1.accept(this);
        
        // Criando a classe class Identifier1 
        ClassContext classeAux = new ClassContext(n.identifier1.toString(), null);
        // Essa classe contém o método main

        if (!mainContext.addClasse(classeAux, Symbol.symbol(n.identifier1.toString())))
            error.complain("Class " + n.identifier1.toString() + " already defined.");
        else
            classe = classeAux;

        Method methodAux = new Method("main", null, null);

        if(!classe.addMethod(methodAux, Symbol.symbol("main")))  
            error.complain("Method main in class " + n.identifier1.toString() + " already defined.");  
        else{
            method = methodAux;
            method.addParametro(null, Symbol.symbol(n.identifier2.toString()));
        }

        n.identifier2.accept(this);
        n.statement.accept(this);
    }

    // Expression e1, e2
    public void visit(AndExpression n){
        n.e1.accept(this);
        n.e2.accept(this);
    }

     // Expression e1, e2
     // Identifier id
    public void visit(ArrayAssignStatement n){
        n.e1.accept(this);
        n.e2.accept(this);
        n.id.accept(this);
    }

    //nothing
    public void visit(ArrayType n){}

    // Identifier id;
	// Expression e;
    public void visit(AssignStatement n){
        n.e.accept(this);
        n.id.accept(this);
    }

    // Expression e1;
	// Identifier id1;
    // ExpList el;
    public void visit(BigExpression n){
        n.id1.accept(this);
        for(int i = 0; i < n.el.size(); i++){
            n.el.elementAt(i).accept(this);
        }
    }

    // Expression e1;
    public void visit(BlockExpression n){
        n.e1.accept(this);
    }

    // StatementList s1;
    public void visit(BlockStatement n){
        for(int i = 0; i < n.s1.size(); i++){
            n.s1.elementAt(i).accept(this);
        }
    }

    // nothing
    public void visit(BooleanType n){}

    // identifier1
    // VarDefinitionList varDeclaration
    // MethodDeclarationList methodDeclaration
    public void visit(ClassSimple n){
        n.identifier1.accept(this);

        // Criando a classe class Identifier1 
        ClassContext classeAux = new ClassContext(n.identifier1.toString(), null);

        if (!mainContext.addClasse(classeAux, Symbol.symbol(n.identifier1.toString()))){
            error.complain("Class " + n.identifier1.toString() + " already defined.");
        }else{
            classe = classeAux;
            method = null;
        }  

        for(int i = 0; i < n.varDeclaration.size(); i++){
            n.varDeclaration.elementAt(i).accept(this);
        }

        for(int i = 0; i < n.methodDeclaration.size(); i++){
            n.methodDeclaration.elementAt(i).accept(this);
        }
    }

    // abstrato
    public void visit(ClassDeclaration n){}

    // Identifier i;
    // Identifier j;
    // VarDefinitionList vl;
    // MethodDeclarationList ml;
    public void visit(ClassDeclarationExtends n){
        n.i.accept(this);
        n.j.accept(this);

        ClassContext classeAux = new ClassContext(n.i.toString(), n.j.toString() );

        if (!mainContext.addClasse(classeAux, Symbol.symbol(n.i.toString()))){
            error.complain("Class " + n.i.toString() + " already defined.");
        }else{
            classe = classeAux;
            method = null;
        }

        for(int i = 0; i < n.vl.size(); i++){
            n.vl.elementAt(i).accept(this);
        }

        for(int i = 0; i < n.ml.size(); i++){
            n.ml.elementAt(i).accept(this);
        }
    }

    // abstrato
    public void visit(Expression n){}

    // nothing
    public void visit(FalseExpression n){}

    // Type type;
    // Identifier identifier;
    public void visit(Formal n){
        n.type.accept(this);
        n.identifier.accept(this);

        if(!method.addParametro(n.type, Symbol.symbol(n.identifier.toString()))){
            error.complain("Param " + n.identifier.toString() + " is defined");
        }
    }

    // abstract
    public void visit(Goal n){}

    // String s;
    public void visit(Identifier n){}

    // String s;
    public void visit(IdentifierExpression n){}

    // String s;
    public void visit(IdentifierType n){}

    // Expression e;
	// Statement s1, s2;
    public void visit(IfStatement n){
        n.e.accept(this);
        n.s1.accept(this);
        n.s2.accept(this);
    }

    // int i;
    public void visit(IntegerLiteralExpression n){}

    // nothing
    public void visit(IntegerType n){}

    // Expression e1;
    public void visit(LengthExpression n){
        n.e1.accept(this);
    }

    // Expression e1, e2;
    public void visit(LessExpression n){
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Expression e1, e2;
    public void visit(ListExpression n){
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // abstract
    public void visit(MainClass n){}

    // abstract
    public void visit(MethodDeclaration n){}

    // Type type;
    // Identifier identifier;
    // FormalList formalList;
    // VarDefinitionList varDefinitionList;
    // StatementList statementList;
    // Expression expression;
    // REGRA DO MÉTODO DECLARATION
    public void visit(MethodDefinition n){
        n.type.accept(this);
        n.identifier.accept(this);

        // Criiando o novo método Type Identifier
        Method newMethod = new Method(n.identifier.toString(), classe.toString(), n.type);

        // Aí eu vejo se esse método já está declarado nessa classe atual, se não tiver eu addMethod e pego o metodo atual como esse metodo que criei
        if (!classe.addMethod(newMethod, Symbol.symbol(n.identifier.toString()))){
            error.complain("Method " + n.identifier.toString() + " already defined.");
        }else{
            method = newMethod;
        }
        
        // Daí os type identifier posteriores (que estão na nossa lista formallist) são os parametros
        // aí eu faço o accept deles que aí lá eles vão ser adicionados
        for(int i = 0; i < n.formalList.size(); ++i){
            n.formalList.elementAt(i).accept(this);
        }

        // Daí as variaveis declaradas para esse metodo estão na nossa lista varDefinitionList
        // aí eu faço o accept deles que aí lá eles vão ser adicionados
        for(int i = 0; i < n.varDefinitionList.size(); ++i){
            n.varDefinitionList.elementAt(i).accept(this);
        }

        // Daí os statement para esse metodo estão na nossa lista statementList
        // aí eu faço o accept deles que aí lá eles vão ser adicionados
        for(int i = 0; i < n.statementList.size(); ++i){
            n.statementList.elementAt(i).accept(this);
        }

        n.expression.accept(this);
    }

    // Expression e1, e2;
    public void visit(MinusExpression n){
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Expression e1, e2;
    public void visit(MultExpression n){
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Identifier id;
    public void visit(NewIdentifierExpression n){
        n.id.accept(this);
    }

    //  Expression e1;
    public void visit(NewIntegerExpression n){
        n.e1.accept(this);
    }

    // Expression e1;
    public void visit(NotExpression n){
        n.e1.accept(this);
    }

    // Expression e1, e2;
    public void visit(PlusExpression n){
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Expression e;
    public void visit(PrintStatement n){
        n.e.accept(this);
    }

    // MainClass mainClass;
    // ClassList classList;
    public void visit(Program n){
        // eu tenho que adicionar a mainclass no maincontext (mas isso ele já faz no visitor do Main)
        n.mainClass.accept(this);
        n.classList.accept(this);

        // e adicionar as classes no maincontext thumbhem, que aí é uma lista e aí eu tenho que percorrer essa lista e dar os accept
        for(int i = 0; i < n.classList.size(); ++i){
            n.classList.elementAt(i).accept(this);
        }
    }

    // abstract
    public void visit(Statement n){}

    // nothing 
    public void visit(ThisExpression n){}

    // nothing 
    public void visit(TrueExpression n){}

    // abstract
    public void visit(Type n){}

    // abstract
    public void visit(VarDeclaration n){}

    // Type type;
    // Identifier identifier;
    public void visit(VarDefinition n){
        n.type.accept(this);
        n.identifier.accept(this);

        // aqui a gente tem que ver se o this é um método ou classe na vdd
        // pra saber se adicionaremos em um método ou em uma classe
        // aí no caso eu verifico se o método atual é nulo, pq isso significa que teremos que adicionar na classe
        if(method == null){
            if(!classe.addVariavel(n.type, Symbol.symbol(n.identifier.toString()))){
                error.complain("Variavel " + n.identifier.toString() + " already defined in the Class.");
            }
        } else {
            if(!method.addVariavel(n.type, Symbol.symbol(n.identifier.toString()))){
                error.complain("Variavel " + n.identifier.toString() + " already defined in the Method.");
            }
        }
        

        

    }

    // Expression e;
    // Statement s1;
    public void visit(WhileStatement n){
        n.e.accept(this);
        n.s1.accept(this);
    }

}