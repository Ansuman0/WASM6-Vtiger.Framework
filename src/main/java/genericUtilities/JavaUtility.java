package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods related to java
 * 
 * @author Ansuman
 *
 */
public class JavaUtility {

	/**
	 * This method will generate a random number and return it to caller
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);
	}

	/**
	 * This method will get system date
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		return d.toString();
	}

	/**
	 * This method will generate system date in required format
	 * 
	 * @return
	 */
	public String getSystemDateInFormat() {

		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[2].replace(":", "-");

		return date + " " + month + " " + year + " - " + time;
	}

	/**
	 * This method will generate system date and provide
	 * 
	 * @return
	 */
	public String getsimpleDateFormat() {
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());
		return date;
	}

	public String getFutureDateString() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		Date futureDateTime = calendar.getTime();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(futureDateTime);
		return formattedDate;
	}

}
