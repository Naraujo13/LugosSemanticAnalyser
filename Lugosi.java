/* Generated By:JavaCC: Do not edit this line. Lugosi.java */
import java.io.*;
import java.util.ArrayList;

public class Lugosi implements LugosiConstants {

  private Main main;
  private ArrayList<Func> funcs;

  public static void main(String args[]) throws ParseException,IOException {

    Lugosi parser = new Lugosi(new FileInputStream(args[0]));
    parser.Lugosi();

  }

  static final public void SeqComandos() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case DO:
      case RETURN:
      case PRINT:
      case ID:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      Comando();
    }
  }

  static final public void Comando() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATRIB:
        jj_consume_token(ATRIB);
        Exp();
        break;
      case APARENTESES:
        jj_consume_token(APARENTESES);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APARENTESES:
        case TRUE:
        case FALSE:
        case ID:
        case NUMERO:
          ListaExp();
          break;
        default:
          jj_la1[1] = jj_gen;
          ;
        }
        jj_consume_token(FPARENTESES);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(APARENTESES);
      Exp();
      jj_consume_token(FPARENTESES);
      jj_consume_token(ACHAVES);
      SeqComandos();
      jj_consume_token(FCHAVES);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(APARENTESES);
      Exp();
      jj_consume_token(FPARENTESES);
      jj_consume_token(ACHAVES);
      SeqComandos();
      jj_consume_token(FCHAVES);
      break;
    case DO:
      jj_consume_token(DO);
      jj_consume_token(ACHAVES);
      SeqComandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(WHILE);
      jj_consume_token(APARENTESES);
      Exp();
      jj_consume_token(FPARENTESES);
      break;
    case PRINT:
      jj_consume_token(PRINT);
      jj_consume_token(APARENTESES);
      Exp();
      jj_consume_token(FPARENTESES);
      break;
    case RETURN:
      jj_consume_token(RETURN);
      Exp();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PVIRGULA);
  }

  static final public void Func() throws ParseException {
    label_2:
    while (true) {
      jj_consume_token(FUNCTION);
      Tipo();
      jj_consume_token(ID);
      jj_consume_token(APARENTESES);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case BOOL:
        ListaArg();
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
      jj_consume_token(FPARENTESES);
      jj_consume_token(ACHAVES);
      VarDecl();
      SeqComandos();
      jj_consume_token(FCHAVES);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
    }
  }

  static final public void ListaArg() throws ParseException {
    Tipo();
    jj_consume_token(ID);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      jj_consume_token(VIRGULA);
      Tipo();
      jj_consume_token(ID);
    }
  }

  static final public void Exp() throws ParseException {
 Exp e1=null;Exp e2=null;Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case APARENTESES:
      jj_consume_token(APARENTESES);
      Exp();
      jj_consume_token(OP);
      Exp();
      jj_consume_token(FPARENTESES);
      break;
    case TRUE:
    case FALSE:
    case ID:
    case NUMERO:
      Fator();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Fator() throws ParseException {
 ExpFator expF=null;ID id=null;ArrayList<Exp> l;Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      t = jj_consume_token(ID);
               id=new ID(t.image);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APARENTESES:
        jj_consume_token(APARENTESES);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APARENTESES:
        case TRUE:
        case FALSE:
        case ID:
        case NUMERO:
          l = ListaExp();
          break;
        default:
          jj_la1[8] = jj_gen;
          ;
        }
        jj_consume_token(FPARENTESES);
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      break;
    case NUMERO:
      t = jj_consume_token(NUMERO);
                  expF = new FatorNum(t.image);
      break;
    case TRUE:
      t = jj_consume_token(TRUE);
                expF = new FatorBool(t.image);
      break;
    case FALSE:
      t = jj_consume_token(FALSE);
                 expF = new FatorBool(t.image);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return expF;}
  }

  static final public void ListaExp() throws ParseException {
    Exp();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_4;
      }
      jj_consume_token(VIRGULA);
      Exp();
    }
  }

  static final public void Tipo() throws ParseException {
 Type type = null; Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      t = jj_consume_token(INT);
                 type = new NUM(t.image);
      break;
    case BOOL:
      t = jj_consume_token(BOOL);
                  type = new Bool(t.image);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return type;}
  }

  static final public void VarDecl() throws ParseException {
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      jj_consume_token(VAR);
      Tipo();
      jj_consume_token(ID);
      jj_consume_token(PVIRGULA);
    }
  }

  static final public void Lugosi() throws ParseException {
    Main();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNCTION:
      Func();
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    jj_consume_token(0);
  }

  static final public void Main() throws ParseException {
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    VarDecl();
    SeqComandos();
    jj_consume_token(FCHAVES);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LugosiTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x41e8000,0xd800200,0x200200,0x41e8000,0x6000,0x400000,0x800,0xd800200,0xd800200,0x200,0xd800000,0x800,0x6000,0x40,0x400000,};
   }

  /** Constructor with InputStream. */
  public Lugosi(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lugosi(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Lugosi(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LugosiTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Lugosi(LugosiTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LugosiTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}

public class Func {

  private Type returnType;
  private String name;
  private ArrayList<Var> args;
  private ArrayList<Var> vars;
  private ArrayList<Comamand> commands;

  public Func(Type returnType, String name, ArrayList<Var> args, ArrayList<Var> vars, ArrayList<Commands> commands){
    this.returnType = returnType;
    this.name = name;
    this.args = new ArrayList(args);
    this.vars = new ArrayList(vars);
    this.commands = ArrayList(commands);
  }

}

public class Main extends Func {

  public Main(List<Var> vars, List<Command> commands){
    super(
      new Int(),
      "main",
      new ArrayList(),
      new ArrayList(vars),
      new ArrayList(commands)
    );
  }

}


public class Var {
  private Type type;
  private String value;

  public Var(String type, String value){
    this.type = type;
    this.value = value;
  }
}

//--- Comandos

public abstract class Command {}

public class Atrib extends Command {
  ID id;
  Exp exp;
}

//If
public class If extends Command {
  //Condition
  Exp exp;
  ArrayList<Comamand> comandos;


}

//While
public class While extends Command {
  Exp exp;
  ArrayList<Command> commandos;
}

//Do While
public class DoWhile extends While {}

//Return
public class Return extends Command {
  private String Value;
}

//Print
public class Print extends Command {
  Exp exp;
}

// ----------------------------------

public class Indexing extends Command {}


//----- Types

public abstract class Type {}

public class Int extends Type{}

public class Bool extends Type{}

// -----------------------------------

//ID
public class ID {
  String nome;

}

//NUM
public class NUM {
  String valor;

  public NUM (String valor){this.valor=valor;}

}

public class Bool {
  String valor;
  public Bool(String valor){this.valor=valor;}
}
//---- Exp

public class Exp extends ExpBase{
  private ExpBase exp1;
  private Op op;
  private ExpBase exp1;
}

public class Fator extends ExpBase {

}

//Base
public abstract class Exp {

}

//Exp op Exp
class ExpOpExp extends Exp {
  Exp exp1;
  String op;
  Exp exp2;
}

//Fator
class ExpFator extends Exp{
  Fator fator;
}

//Fator base
public abstract class Fator {}

//Fator = id ou Fator = lista
class FatorId extends Fator {
  ID id;
}

//Fator = num
class FatorNum extends Fator {
  NUM num;
}


//Fator = bool
class FatorBool extends Fator {
  Bool valor;
}
