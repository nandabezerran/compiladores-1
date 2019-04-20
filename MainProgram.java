import analisador_lexico.*;
import analisador_semantico.*;
import java.io.*;
import com.sun.javafx.scene.paint.GradientUtils.Parser;

public class MainProgram {
	public static void main(String[] args) throws Exception
	{		
		//String filePath = new File("").getAbsolutePath();
		//System.out.println(filePath);
		//Parser parser = new Parser(new FileReader(filePath+path));
		Parser parser = new Parser(new java.io.FileInputStream(args[0]));
		Program programa = parser.Start();
		
		//Declarar o visitor pra construção da tabela de símbolos e chamar abaixo
		//programa.visit(new SystemContext());

		///--------------------------------------

		// Declarar o visitor pra checagem de tipos e chamar abaixo
		//TypeChecking checagem = new TypeCkecking(tabela de simbolo);
		//checagem.visit(c)
	}
}