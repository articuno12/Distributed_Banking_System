import java.util.*;
import java.text.*;

//class for return values
public class tuple
{
  private Integer tid;
  private Integer balance;
  tuple(Integer _tid,Integer b)
  {
    tid = _tid;
    balance = b;
  }
  public Integer getId()
  {
    return tid;
  }
  public Integer getbalance()
  {
    return balance;
  }
}
