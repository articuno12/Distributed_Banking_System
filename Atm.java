import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.*;
import java.text.*;

public class Atm
{
  private Atm(){};
  public static void main(String args[])
  {
    Registry registry;
    BankInterface stub = null;
    try
    {
      registry = LocateRegistry.getRegistry(null);
      stub = (BankInterface) registry.lookup("BankInterface");
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
    // main program
    String ac = "1";
    try
    {
    stub.addaccount("Kritika",ac,"8080","Saving",2000);
    System.out.println(stub.deposit(ac,1000));
    System.out.println(stub.withdraw(ac,300));
    System.out.println(stub.inquiry(ac));
  }
  catch (Exception e)
  {
    System.out.println(e);
  }
  }
}
