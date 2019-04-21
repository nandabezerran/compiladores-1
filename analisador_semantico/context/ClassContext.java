package context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ClassContext {
    String nome;
    String pai;
    Map<Symbol, Type> fields;
    Map<Symbol, Method> methods;

    public ClassContext(String nome, String pai){
        this.nome = nome;
        this.pai = pai;
        this.local = new HashMap<Symbol, Type>();
        this.methods = new HashMap<Symbol, Method>();
    }

    // método para adicionar parametro
    public void addMethod(Method method, Symbol symbol){
        this.methods.put(symbol, method);
    }

    // método para adicionar variavel
    public void addVariavel(Type tipo, Symbol simbol){
        this.local.put(simbol, tipo);
    }

    // get parametros
    public Map<Symbol, Method> getMethods(){
        return this.methods;
    }

    // get variaveis
    public Map<Symbol, Type> getVars(){
        return this.local;
    }

    // get parametros
    public Method getMethods(Symbol symbol){
        return this.methods.get(symbol);
    }

    // get variaveis
    public Type getVars(Symbol symbol){
        return this.local.get(symbol);
    }

    public int getMethodSize() {
        return this.methods.size();
    }

    public int getVarSize() {
        return this.local.size();
    }

    public String toString(){
        return this.nome;
    }

    public String getPai(){
        return this.pai;
    }

    public boolean removeVar(Symbol symbol){
        if(this.local.get(symbol) == null)
            return false;
        this.fields.remove(symbol);
        return true;
    }

    public boolean removeMethod(Symbol symbol){
        if(this.methods.get(symbol) == null)
            return false;
        this.methods.remove(symbol);
        return true;
    }

}