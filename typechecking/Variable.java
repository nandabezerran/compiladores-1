package typechecking;
import syntaxtree.*;
public class VarEntry {
    String vName;
    Type vType;

    public VarEntry(String s, Type t) {
        this.vName = s;
        this.vType = t;
    }

    public String getName() {
        return vName;
    }
    public Type getType(){
        return vType;
    }
}