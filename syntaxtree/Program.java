package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class Program extends Goal {
    MainClass mainClass;
    ClassDeclaration classDeclaration;
    public Program(MainClass pMainClass, ClassDeclaration pClassDeclaration) {
        mainClass        = pMainClass;
        classDeclaration = pClassDeclaration; 
    }

    public void accept(Visitor v) {
        return v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}