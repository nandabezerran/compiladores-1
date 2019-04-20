package syntaxtree;

import java.util.Vector;

public class VarDefinitionList {
   private Vector list;

   public VarDefinitionList() {
      list = new Vector();
   }

   public void addElement(VarDeclaration n) {
      list.addElement(n);
   }

   public VarDeclaration elementAt(int i)  { 
      return (VarDeclaration)list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }
}