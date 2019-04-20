package syntaxtree;
import java.util.Vector;
import visitor.*;

public class ExpList {
   private Vector list;

   public ExpList() {
      list = new Vector();
   }

   public void addElement(Expression n) {
      list.addElement(n);
   }

   public Expression elementAt(int i)  { 
      return (Expression)list.elementAt(i); 
   }

   public int size() { 
      return list.size(); 
   }
}