package syntaxtree;

import java.util.Vector;

public class ClassDeclList {
    private Vector list;

    public ClassDeclList() {
        list = new Vector();
    }

    public void addElement(ClassDeclaration n) {
        list.addElement(n);
    }

    public ClassDeclaration elementAt(int i)  {
        return (ClassDeclaration)list.elementAt(i);
    }

    public int size() {
        return list.size();
    }
}
