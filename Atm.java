import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.*;
import java.text.*;
import java.util.Scanner;

public class Atm
{
		private Atm(){};
		public static void main(String args[])
		{
				Registry registry;
				BankInterface stub = null;
				Scanner in = null;
				try
				{
						registry = LocateRegistry.getRegistry(null);
						stub = (BankInterface) registry.lookup("BankInterface");
						in = new Scanner(System.in);
				}
				catch (Exception e)
				{
						System.out.println(e);
				}
				// main program
				try
				{
						while(true)
						{
								System.out.println("1 : check_balance");
								System.out.println("2 : deposit_money");
								System.out.println("3 : withdraw_money");
								System.out.println("4 : transaction details between dates") ;
								System.out.println("5 : transaction details") ;
								System.out.println("6 : addaccount");
								int type = in.nextInt() ;
								if(type == 0) break ;
								else if (type == 1)
								{
										String ac = in.next();
										int b = stub.inquiry(ac);
										System.out.println("Av. Balance:" + b);
								}
								else if(type == 2)
								{
										String ac = in.next();
										int amount = in.nextInt();
										tuple ans = stub.deposit(ac,amount);
										if(ans.getId() ==0 && ans.getbalance()==0)
												System.out.println("Account doesnt exist");
										else
										{
												System.out.println("Amount deposited");
												System.out.println("Transaction Id:" + ans.getId() );
												System.out.println("Updated balance:" + ans.getbalance());
										}
								}
								else if(type == 3)
								{
										String ac = in.next();
										int amount = in.nextInt();
										tuple ans = stub.withdraw(ac,amount);
										if(ans.getId() ==0 && ans.getbalance()==0)
												System.out.println("Account doesnt exist");
										else
										{
												System.out.println("Amount deposited");
												System.out.println("Transaction Id:" + ans.getId() );
												System.out.println("Updated balance:" + ans.getbalance());
										}
								}
								else if(type == 4)
								{
										String ac = in.next();
										System.out.println("Enter dates in format yyyy-MM-dd");
										String date1 = in.next();
										String date2 = in.next();
										SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
										Date start_date = null;
										Date end_date = null;
										try
										{
												start_date = df.parse(date1);
												end_date = df.parse(date2);
										}
										catch (ParseException e)
										{
												System.out.println(e);
										}
										List<Transaction> ans = stub.transaction_history(ac,start_date,end_date);
										String leftAlignFormat = "| %-5s| %-30s |%n";
										System.out.format("+------+--------------------------------+%n");
										System.out.format("| ID   | Transaction Date and Time      |%n");
										System.out.format("+------+--------------------------------+%n");
										for(int i = 0;i < ans.size();++i)
										{
												System.out.format(leftAlignFormat,ans.get(i).getId() , ans.get(i).getDate()) ;
										}
										System.out.format("+------+--------------------------------+%n");
								}
								else if(type == 5)
								{
										String ac = in.next();
										List<Transaction> ans = stub.transaction_history(ac);
										String leftAlignFormat = "| %-5s| %-30s |%n";
										System.out.format("+------+--------------------------------+%n");
										System.out.format("| ID   | Transaction Date and Time      |%n");
										System.out.format("+------+--------------------------------+%n");
										for(int i = 0;i < ans.size();++i)
										{
												System.out.format(leftAlignFormat,ans.get(i).getId() , ans.get(i).getDate()) ;
										}
										System.out.format("+------+--------------------------------+%n");
								}
								else if(type == 6)
								{
										String name = in.next();
										String ac = in.next();
										String contactinfo = in.next();
										String type = in.next();
										int balance = in.nextInt();
										stub.openaccount(name,ac,contactinfo,type,balance);
								}
						}
				}
				catch(Exception e)
				{
						System.out.println(e) ;
				}

		}
}
