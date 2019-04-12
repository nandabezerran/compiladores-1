package syntaxtree;

import java.util.Vector;

public class StatementList {
   private Vector statementList;

   public StatementList() {
      statementList = new Vector();
   }

   public void addElement(Statement pStatement) {
      statementList.addElement(pStatement);
   }

   public Statement elementAt(int pElement)  { 
      return (Statement)statementList.elementAt(pElement); 
   }

   public int size() { 
      return statementList.size(); 
   }
}