package visitor;

import java.util.*;
import syntaxtree.*;
import context.*;
impoty

public class SymbolTable implements Visitor{

    private MainContext mainContext;
    private Class classe;
    private Method method;
    private Error error;

    public SymbolTable(){
        mainContext = new MainContext();
        erros = new Error();
        method = null;
        classe = null;
    }

    //Identifier id1, id2
    public void visit(Main n){

        n.identifier1.accept(this);
        //duvida se é o toString mesmo
        Class classeAux = new Class(n.identifier1.toString());
        if (!mainContext.addClasse(classeAux, Symbol.symbol(n.identifier1.toString())))
            error.complain("Class "+n.identifier1.toString()+" already defined.")
        else
            classe = classeAux;

        n.identifier2.accept(this);

        Method methodAux = new Method("main", null);

        if(!classe.addMethod(methodAux, Symbol.symbol("main")))  
            error.complain("Method main in class "+n.identifier1.toString()+" already defined.");  
        else{
            method = methodAux;
            method.addParametro(null, Symbol.symbol(n.identifier2.toString()));
        }
        
        n.statement.accept(this);
    }







}