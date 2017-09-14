import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankInterface extends Remote
{
		public tuple deposit(String account, Integer amount)
				throws RemoteException;
		public tuple withdraw(String account, Integer amount)
				throws RemoteException;
		public Integer inquiry(String account)
				throws RemoteException;
		public void addaccount(String name,String ac,String contactinfo,String type,Integer balance)
				throws RemoteException;
		public List<Transaction> transaction_history(String account, Date start,Date end)
				throws RemoteException;
		public ArrayList<Transaction> transaction_history(String account)
				throws RemoteException;
}
