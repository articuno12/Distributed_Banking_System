import java.util.*;
import java.text.*;

//class for maintaining transaction details
public class Transaction
{
		private Integer id;
		private Date date;
		Transaction(Integer tid,Date tdate)
		{
				id = tid;
				date = tdate;
		}
		public Integer getId()
		{
				return id;
		}
		public Date getDate()
		{
				return date;
		}
}
