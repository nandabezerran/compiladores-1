package context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainContext {
    String nome;
    Map<Symbol, Class> classes;

    public MainContext(String nome){
        this.nome = nome;
        this.classes = new HashMap<Symbol, Class>();
    }

    public MainContext(){
        this.classes = new HashMap<Symbol, Class>();
    }

    // método para adicionar classe
    public void addClasse(Class classe, Symbol simbol){
        this.classes.put(simbol, classe);
    }

     // get classes
     public Map<Symbol, Class> getClasses(){
        return this.classes;
    }

    // get classe
    public Class getClasses(Symbol symbol){
        return this.classes.get(symbol);
    }

    public String toString(){
        return this.nome;
    }

    public boolean removeClass(Symbol symbol){
        if(this.classes.get(symbol) == null)
            return false;
        this.classes.remove(symbol);
        return true;
    }
}                              