import java.util.*;
import java.text.*;
//class for maintaining each account detail
public class Account
{
  private String account_no;
  private String name;
  private String type;
  private String contact;
  private Integer balance;
  private List<Transaction> transactions;
  Account(String n,String ac,String t,String c, Integer b)
  {
    name = n;
    account_no = ac;
    type  = t;
    contact = c;
    balance = b;
    //initialise transaction table
    transactions = new ArrayList<Transaction>();
  }
  public String getname()
  {
    return name;
  }
  public String gettype()
  {
    return type;
  }
  public String getcontact()
  {
    return contact;
  }
  public String getaccount()
  {
    return account_no;
  }
  public Integer getbalance()
  {
    return balance;
  }
  public void updatebalance(Integer change,Integer tid, Date date)
  {
    balance += change;
    updatetransaction(tid,date);
  }
  public void updatetransaction(Integer tid, Date date)
  {
    Transaction t = new Transaction(tid,date);
    transactions.add(t);
  }
  public ArrayList<Transaction> gettransaction(Date date1, Date date2)
  {
    return new ArrayList<Transaction>();
  }
}
