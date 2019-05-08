import analisador_lexico.*;
import analisador_semantico.syntaxtree.*;
import analisador_semantico.syntaxtree.Program;
import analisador_semantico.visitors.ImplIR;
import analisador_semantico.visitors.SymbolTable;
import analisador_semantico.visitors.TypeChecking;
import traducao_intermediario.visitor.*;
import traducao_intermediario.Translate.Exp;
import traducao_intermediario.Mips.*;
import java.io.*;

public class MainProgram {
	public static void main(String[] args) throws Exception {
		// String filePath = new File("").getAbsolutePath();
		// System.out.println(filePath);
		// Parser parser = new Parser(new FileReader(filePath+path));
		Parser parser = new Parser(new java.io.FileInputStream(args[0]));
		Program programa = parser.Goal();

		// Declarar o visitor pra construção da tabela de símbolos e chamar abaixo
		SymbolTable table = new SymbolTable();
		programa.accept(table);

		/// --------------------------------------
		// Declarar o visitor pra checagem de tipos e chamar abaixo
		TypeChecking checking = new TypeChecking(table.getTable());
		programa.accept(checking);

		// --------------------------------------
		// Declarar o visitor pra tradução do código intermediário
		ImplIR intermediario = new ImplIR(table.getTable(), new MipsFrame()); // TODO passar os parametros do MipsFrame
		programa.accept(intermediario);
	}
}