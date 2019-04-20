package context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Method {
    String nome;
    Type tipo;
    Class pai;
    Map<Symbol, Type> params;
    Map<Symbol, Type> local;

    public Method(String nome, Class pai, Type tipo){
        this.nome = nome;
        this.pai = pai;
        this.tipo = tipo;
        this.params = new HashMap<Symbol, Type>();
        this.local = new HashMap<Symbol, Type>();
    }

    // método para adicionar parametro
    public void addParametro(Type tipo, Symbol simbol){
        this.params.put(simbol, tipo);
    }

    // método para adicionar variavel
    public void addVariavel(Type tipo, Symbol simbol){
        this.local.put(simbol, tipo);
    }

    // get parametros
    public Map<Symbol, Type> getParams(){
        return this.params;
    }

    // get variaveis
    public Map<Symbol, Type> getVars(){
        return this.local;
    }

    // get parametros
    public Type getParams(Symbol symbol){
        return this.params.get(symbol);
    }

    // get variaveis
    public Type getVars(Symbol symbol){
        return this.local.get(symbol);
    }

    public int getParamsSize() {
        return this.params.size();
    }

    public int getVarSize() {
        return this.local.size();
    }

    public Type getType(){
        return this.type;
    }

    public String toString(){
        return this.nome;
    }

    public Class getPai(){
        return this.pai;
    }

    public boolean removeVar(Symbol symbol){
        if(this.local.get(symbol) == null)
            return false;
        this.local.remove(symbol);
        return true;
    }

    public boolean removeParam(Symbol symbol){
        if(this.params.get(symbol) == null)
            return false;
        this.params.remove(symbol);
        return true;
    }
    
}