package genericUtilities;

import java.util.Date;
import java.util.Random;

import net.datafaker.Faker;

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
	 * This method genrate fake data by using Datafacker class.
	 * @return
	 */

	public  String generateRandomFirstName() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		// To generate a valid random first name
		return faker.name().firstName();
	}
	public  String generateRandomLastName() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		// To generate a valid random first name
		return faker.name().firstName();
	}
	public  String generateRandomCompany() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		// To generate a valid random first name
		return faker.company().name();
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
	public String getSystemInFormat() {
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[2].replace(":", "-");

		return date + " " + month + " " + year + " - " + time;
	}

}
