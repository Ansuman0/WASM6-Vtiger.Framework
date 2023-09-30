package genericUtilities;

import net.datafaker.Faker;

/**
 * This class consists of generic methods related to Random data.
 * 
 * @author Ansuman
 */

public class RandomDataUtility {

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
		return faker.name().lastName();
	}
	
	public String generateRandomFullName() {
		// Create an object of Faker class with default locale i.e ENG
		Faker faker = new Faker();
		return faker.name().name();
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

	public String generateOrganizationName() {
		Faker faker = new Faker();
		return faker.company().name();
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

	public String generateOpportunity() {
		Faker faker = new Faker();

		// Generate fake opportunity data
		return faker.company().buzzword() + "opportunity";
	}

	public String generateDescription() {
		Faker faker = new Faker();
		String description = faker.lorem().sentence();
		return description;
	}

	public String generateRandomAmount() {
		Faker faker = new Faker();
		// Generate a random amount (e.g., for currency)
		double amount = faker.number().randomDouble(2, 10, 1000);
		String str = Double.toString(amount);
		return str;
	}
}
