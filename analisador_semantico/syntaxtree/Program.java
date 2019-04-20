//package syntaxtree;
//import visitor.*;

public class Program extends Goal {
    MainClass mainClass;
    ClassList classList;
    
    public Program(MainClass pMainClass, ClassList pClassDeclaration) {
        mainClass = pMainClass;
        classList = pClassDeclaration;
    }

    /*public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }*/
}