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

		public List<Transaction> transaction_details(Date date1, Date date2)
		{
				Comparator<Transaction> construct = new Comparator<Transaction>()
				{
						public Integer compare(Transaction t1, Transaction t2)
						{
								if(t1.getDate().before(t2.getDate())) return -1;
								if(t1.getDate().after(t2.getDate())) return 1;
								else return 0 ;
						}
				}
				Integer l = Collections.binarySearch(transactions,new Transaction(0,date1),construct);
				Integer r = Collections.binarySearch(transactions,new Transaction(0,date2),construct);
				if(l<0) l = -1*l - 1;
				if(r<0) r = -1*r - 1;
				List<Transaction> t = new ArrayList<Transaction>();
				for(int i=l;i<r;++i) t.add(transactions.get(i));
				return t;
		}
		public ArrayList<Transaction> gettransaction()
		{
				return transactions;
		}
}
