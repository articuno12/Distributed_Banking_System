import java.util.*;
import java.text.*;
import java.io.Serializable ;

//class for return values
public class tuple implements Serializable
{
		private Integer tid;
		private Integer balance;
		private Date date;
		tuple(Integer _tid,Integer b)
		{
				tid = _tid;
				balance = b;
		}
		tuple(Integer _tid,Date _date)
		{
			tid = _tid;
			date = _date;
		}
		public Integer getId()
		{
				return tid;
		}
		public Integer getbalance()
		{
				return balance;
		}
		public Date getDate()
		{
			return date;
		}
}
