package traducao_intermediario.Mips;
import traducao_intermediario.Tree.*;

public abstract class Access {
  public abstract String toString();
  public abstract Expr exp(Expr e);
}
