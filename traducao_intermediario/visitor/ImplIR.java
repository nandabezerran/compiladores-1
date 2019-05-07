package analisador_semantico.visitors;

import analisador_semantico.context.*;
import analisador_semantico.syntaxtree.*;
import traducao_intermediario.visitor.*;
import traducao_intermediario.Frame.*;
import traducao_intermediario.Translate.*;
import traducao_intermediario.Tree.*;
import traducao_intermediario.Temp.*;

public class ImplIR implements VisitorIR {
    private Frame currFrame;
    private Frag frag_inicio;
    private Frag frags;
    private MainContext mainContext;
    private ClassContext classe;
    private Method method;

    public ImplIR(MainContext maincontext, Frame frame) {
        this.mainContext = maincontext;
        this.currFrame = frame;
        this.frags = new Frag(null);
        this.frag_inicio = frags;
        method = null;
        classe = null;
    }

    public Frag getFrag() {
        return this.frags;
    }

    // MainClass mainClass;
    // ClassList classList;
    @Override
    public Exp visit(Program n) {
        n.mainClass.accept(this);

        for (int i = 0; i < n.classList.size(); ++i) {
            n.classList.elementAt(i).accept(this);
        }
        return null;
    }


    public Expr visit(Program pProgram) {
        pProgram.mainClass.accept(this);
        for ( int i = 0; i < pProgram.classList.size(); i++ ) {
            pProgram.classList.elementAt(i).accept(this);
        }
        return null;
    }


    @Override
    public Exp visit(Main n) {
        n.identifier1.accept(this);

        // Criando a classe class Identifier1
        ClassContext classeAux = new ClassContext(n.identifier1.toString(), null);
        // Essa classe contém o método main

        if (!mainContext.addClasse(classeAux, Symbol.symbol(n.identifier1.toString())))
            error.complain("Class " + n.identifier1.toString() + " already defined.");
        else
            classe = classeAux;

        Method methodAux = new Method("main", null, null);

        if (!classe.addMethod(methodAux, Symbol.symbol("main")))
            error.complain("Method main in class " + n.identifier1.toString() + " already defined.");
        else {
            method = methodAux;
            method.addParametro(null, Symbol.symbol(n.identifier2.toString()));
        }

        n.identifier2.accept(this);
        n.statement.accept(this);
    }

    // Expression e1, e2
    @Override
    public Exp visit(AndExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Expression e1, e2
    // Identifier id
    @Override
    public Exp visit(ArrayAssignStatement n) {
        return new MOVE(new BINOP(BINOP.PLUS, new MEM(new TEMP(n.id.toString())), n.e1.accept(this)),
                n.e2.accept(this));
    }

    // nothing
    @Override
    public Exp visit(ArrayType n) {
        return null;
    }

    // Identifier id;
    // Expression e;
    @Override
    public Exp visit(AssignStatement n) {
        return new MOVE(new TEMP(n.id.toString()), n.e.accept(this));
    }

    // Expression e1;
    // Identifier id1;
    // ExpList el;
    @Override
    public Exp visit(BigExpression n) {
        n.id1.accept(this);
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
    }

    // Expression e1;
    @Override
    public Exp visit(BlockExpression n) {
        n.e1.accept(this);
    }

    // StatementList s1;
    @Override
    public Exp visit(BlockStatement n) {
        Stm atual, prox;
        SEQ seq;
        atual = n.s1.elementAt(0).accept(this);

        for (int i = 1; i < n.s1.size(); i++) {
            prox = n.s1.elementAt(i).accept(this);
            seq = new SEQ(seq,prox);
        }
        return (Exp) seq;
    }

    // nothing
    @Override
    public Exp visit(BooleanType n) {
        return null;
    }

    // identifier1
    // VarDefinitionList varDeclaration
    // MethodDeclarationList methodDeclaration
    @Override
    public Exp visit(ClassSimple n) {
        n.identifier1.accept(this);

        // Criando a classe class Identifier1
        ClassContext classeAux = new ClassContext(n.identifier1.toString(), null);

        if (!mainContext.addClasse(classeAux, Symbol.symbol(n.identifier1.toString()))) {
            error.complain("Class " + n.identifier1.toString() + " already defined.");
        } else {
            classe = classeAux;
            method = null;
        }

        for (int i = 0; i < n.varDeclaration.size(); i++) {
            n.varDeclaration.elementAt(i).accept(this);
        }

        for (int i = 0; i < n.methodDeclaration.size(); i++) {
            n.methodDeclaration.elementAt(i).accept(this);
        }
    }

    // abstrato
    @Override
    public Exp visit(ClassDeclaration n) {
    }

    // Identifier i;
    // Identifier j;
    // VarDefinitionList vl;
    // MethodDeclarationList ml;
    @Override
    public Exp visit(ClassDeclarationExtends n) {
        n.i.accept(this);
        n.j.accept(this);

        ClassContext classeAux = new ClassContext(n.i.toString(), n.j.toString());

        if (!mainContext.addClasse(classeAux, Symbol.symbol(n.i.toString()))) {
            error.complain("Class " + n.i.toString() + " already defined.");
        } else {
            classe = classeAux;
            method = null;
        }

        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }

        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }
    }

    // abstrato
    @Override
    public Exp visit(Expression n) {
    }

    // nothing
    @Override
    public Exp visit(FalseExpression n) {
    }

    // Type type;
    // Identifier identifier;
    @Override
    public Exp visit(Formal n) {
        n.type.accept(this);
        n.identifier.accept(this);

        if (!method.addParametro(n.type, Symbol.symbol(n.identifier.toString()))) {
            error.complain("Param " + n.identifier.toString() + " is defined in the Method " + method.toString());
        }
    }

    // abstract
    @Override
    public Exp visit(Goal n) {
    }

    // String s;
    @Override
    public Exp visit(Identifier n) {
    }

    // String s;
    @Override
    public Exp visit(IdentifierExpression n) {
    }

    // String s;
    @Override
    public Exp visit(IdentifierType n) {
    }

    // Expression e;
    // Statement s1, s2;
    @Override
    public Exp visit(IfStatement n) {
        n.e.accept(this);
        n.s1.accept(this);
        n.s2.accept(this);
    }

    // int i;
    @Override
    public Exp visit(IntegerLiteralExpression n) {
    }

    // nothing
    @Override
    public Exp visit(IntegerType n) {
        return null;
    }

    // Expression e1;
    @Override
    public Exp visit(LengthExpression n) {
        n.e1.accept(this);
    }

    // Expression e1, e2;
    @Override
    public Exp visit(LessExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Expression e1, e2;
    @Override
    public Exp visit(ListExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // abstract
    @Override
    public Exp visit(MainClass n) {
    }

    // abstract
    @Override
    public Exp visit(MethodDeclaration n) {
    }

    // Type type;
    // Identifier identifier;
    // FormalList formalList;
    // VarDefinitionList varDefinitionList;
    // StatementList statementList;
    // Expression expression;
    // REGRA DO MÉTODO DECLARATION
    @Override
    public Exp visit(MethodDefinition n) {
        n.type.accept(this);
        n.identifier.accept(this);

        // Criiando o novo método Type Identifier
        Method newMethod = new Method(n.identifier.toString(), classe.toString(), n.type);

        // Aí eu vejo se esse método já está declarado nessa classe atual, se não tiver
        // eu addMethod e pego o metodo atual como esse metodo que criei
        if (!classe.addMethod(newMethod, Symbol.symbol(n.identifier.toString()))) {
            error.complain("Method " + n.identifier.toString() + " already defined.");
        } else {
            method = newMethod;
        }

        // Daí os type identifier posteriores (que estão na nossa lista formallist) são
        // os parametros
        // aí eu faço o accept deles que aí lá eles vão ser adicionados
        for (int i = 0; i < n.formalList.size(); ++i) {
            n.formalList.elementAt(i).accept(this);
        }

        // Daí as variaveis declaradas para esse metodo estão na nossa lista
        // varDefinitionList
        // aí eu faço o accept deles que aí lá eles vão ser adicionados
        for (int i = 0; i < n.varDefinitionList.size(); ++i) {
            n.varDefinitionList.elementAt(i).accept(this);
        }

        // Daí os statement para esse metodo estão na nossa lista statementList
        // aí eu faço o accept deles que aí lá eles vão ser adicionados
        for (int i = 0; i < n.statementList.size(); ++i) {
            n.statementList.elementAt(i).accept(this);
        }

        n.expression.accept(this);
    }

    // Expression e1, e2;
    @Override
    public Exp visit(MinusExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Expression e1, e2;
    @Override
    public Exp visit(MultExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Identifier id;
    @Override
    public Exp visit(NewIdentifierExpression n) {
        n.id.accept(this);
    }

    // Expression e1;
    @Override
    public Exp visit(NewIntegerExpression n) {
        n.e1.accept(this);
    }

    // Expression e1;
    @Override
    public Exp visit(NotExpression n) {
        n.e1.accept(this);
    }

    // Expression e1, e2;
    @Override
    public Exp visit(PlusExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Expression e;
    @Override
    public Exp visit(PrintStatement n) {
        n.e.accept(this);
    }

    // abstract
    @Override
    public Exp visit(Statement n) {
    }

    // nothing
    @Override
    public Exp visit(ThisExpression n) {
    }

    // nothing
    @Override
    public Exp visit(TrueExpression n) {
    }

    // abstract
    @Override
    public Exp visit(Type n) {
        return null;
    }

    // abstract
    @Override
    public Exp visit(VarDeclaration n) {
    }

    // Type type;
    // Identifier identifier;
    @Override
    public Exp visit(VarDefinition n) {
        n.type.accept(this);
        n.identifier.accept(this);

        // aqui a gente tem que ver se o this é um método ou classe na vdd
        // pra saber se adicionaremos em um método ou em uma classe
        // aí no caso eu verifico se o método atual é nulo, pq isso significa que
        // teremos que adicionar na classe
        if (method == null) {
            if (!classe.addVariavel(n.type, Symbol.symbol(n.identifier.toString()))) {
                error.complain(
                        "Variavel " + n.identifier.toString() + " already defined in the Class " + classe.toString());
            }
        }
        if (method != null) {
            if (!method.addVariavel(n.type, Symbol.symbol(n.identifier.toString()))) {
                error.complain("Variavel " + n.identifier.toString() + " already defined in the Method "
                        + method.toString() + " Class " + classe.toString());
            }
        }

    }

    // Expression e;
    // Statement s1;
    @Override
    public Exp visit(WhileStatement n) {
        Expr exp = n.e.accept(this).unEx();
        Exp stm = n.s1.accept(this);

        Label loop = new Label();
        Label fim = new Label();
        Label inicio = new Label();

        SEQ seqInicio = new SEQ(new JUMP(inicio), new LABEL(fim));
        SEQ seqLoop = new SEQ(new LABEL(loop), seqInicio);
        SEQ seqCJump = new SEQ(new CJUMP(CJUMP.EQ, new CONST(1), exp, loop, fim), seqLoop);
        SEQ seqMain = new SEQ(new LABEL(inicio), seqCJump);

        // mas o tipo vai ser Stm ou Exp?
        return seqMain;
    }

}