import java.text.SimpleDateFormat;  
import java.util.Date;

public class Administrator 
{
	public Date takeCurrentTime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    return date;
	}
	
	public void printCurrentDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
	    System.out.println(formatter.format(date));
	}
	
}
