import java.util.*;
import java.text.*;

public class BankImplementation implements BankInterface
{
  private HashMap<String,Account> bankdata;
  private Integer tnumber;
  BankImplementation()
  {
    tnumber = 0;
    bankdata = new HashMap<String,Account>();
  }
  public tuple withdraw(String account, Integer amount)
  {
    if(bankdata.get(account) == null)
    {
        System.out.println("Account doesnt exist");
        tuple ans = new tuple(0,0);
        return ans;
    }
    ++tnumber;
    Date date = new Date();
    bankdata.get(account).updatebalance(-1*amount,tnumber,date);
    Integer b = bankdata.get(account).getbalance();
    tuple ans = new tuple(tnumber,b);
    return ans ;
  }
  public tuple deposit(String account,Integer amount)
  {
    if(bankdata.get(account) == null)
    {
        System.out.println("Account doesnt exist");
        tuple ans = new tuple(0,0);
        return ans;
    }
    ++tnumber;
    Date date = new Date();
    bankdata.get(account).updatebalance(amount,tnumber,date);
    Integer b = bankdata.get(account).getbalance();
    tuple ans = new tuple(tnumber,b);
    return ans ;
  }
  public Integer inquiry(String account)
  {
    Integer b = bankdata.get(account).getbalance();
    return b;
  }
  public void addaccount(String name,String ac,String contactinfo,String type,Integer balance)
  {
      Account a = new Account(name,ac,type,contactinfo,balance) ;
      bankdata.put(ac,a) ;
      System.out.println("Account : " + ac) ;
  }
}
