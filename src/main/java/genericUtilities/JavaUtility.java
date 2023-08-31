package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	 * 
	 * @return
	 */

	public String generateRandomFirstName() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public String generateRandomLastName() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.name().firstName();
	}

	public String generateRandomCompany() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.company().name();
	}

	public String generateRandomIndusty() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.company().industry();
	}

	public String generateRandomCompanyDetails() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.company().catchPhrase();
	}

	public String generateRandomProduct() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.commerce().productName();
	}

	public String generateRandomCampaigingName() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.company().buzzword() + " Campaign";
	}

	public String generateFakeEmails() {
		Faker faker = new Faker();
		String username = faker.name().username().replaceAll("[^a-zA-Z0-9]", "");
		String domain = faker.internet().domainName();
		return username + "@" + domain;
	}

	public String generateFakeWebsiteName() {
		Faker faker = new Faker();
		String prefix = faker.color().name().toLowerCase();
		String domain = faker.internet().domainName();
		return prefix + domain;
	}

	public String generateFullAddress() {
		Faker faker = new Faker();
		String streetAddress = faker.address().streetAddress();
		String city = faker.address().city();
		String state = faker.address().state();
		String zipCode = faker.address().zipCode();
		String country = faker.address().country();

		String fullAddress = streetAddress + ", " + city + ", " + state + " " + zipCode + ", " + country;
		return fullAddress;
	}

	public String generateFakePhoneNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().cellPhone();
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
