package genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to java
 * @author Ansuman
 *
 */
public class JavaUtility {

	/**
	 * This method will generate a random number and return it to caller
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * This method will get system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	/**
	 * This method will generate system date in required format
	 * @return
	 */
	public String getSystemInFormat()
	{
		Date d = new Date();
		String[] dArr=d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		
		return date+" "+month+" "+year+" "+time;
	}
	
}
