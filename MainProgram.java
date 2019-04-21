import analisador_lexico.*;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.syntaxtree.Program;
import analisador_semantico.visitors.SymbolTable;

import java.io.*;

public class MainProgram {
	public static void main(String[] args) throws Exception
	{		
		//String filePath = new File("").getAbsolutePath();
		//System.out.println(filePath);
		//Parser parser = new Parser(new FileReader(filePath+path));
		Parser parser = new Parser(new java.io.FileInputStream(args[0]));
		Program programa = parser.Goal();
		
        //Declarar o visitor pra construção da tabela de símbolos e chamar abaixo
        SymbolTable table = new SymbolTable();
        programa.accept(table);

		///--------------------------------------

		// Declarar o visitor pra checagem de tipos e chamar abaixo
		//TypeChecking checagem = new TypeCkecking(tabela de simbolo);
		//checagem.visit(c)
	}
}