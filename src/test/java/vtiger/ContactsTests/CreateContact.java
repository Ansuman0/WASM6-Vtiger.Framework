package vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */

public class CreateContact extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createContactTest() throws Exception {
		

		// Step 3: read all the required data
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2) + jUtil.getRandomNumber();

		// Step 4: Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		

		// Step 5: Navigate to create Contact Look up image
		ContactsPage  cp = new ContactsPage(driver);
		cp.clickOnContactsLookUpImage();

		// Step 6: create contact with mandatory details and save
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);

		// Step 7: Validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME));

	}
}
