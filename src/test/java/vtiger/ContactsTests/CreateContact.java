package vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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


@Epic("Web Application SmokeSuite Testing")
@Feature("Login Page Tests")
@Listeners(ListenersImplementation.class)
public class CreateContact extends BaseClass {
	
	
	
	@Test(groups = "SmokeSuite")
	public void createContactTest() throws Exception {
		

		// Step 3: read all the required data
		String LASTNAME = jUtil.generateRandomFirstName() +" "+ jUtil.generateRandomLastName();
		

		// Step 4: Navigate to Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		

		// Step 5: Navigate to create Contact Look up image
		ContactsPage  cp = new ContactsPage(driver);
		cp.clickOnContactsLookUpImage();

		// Step 6: create contact with mandatory details and save
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
		System.out.println("Name : "+LASTNAME);

		// Step 7: Validate
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		wUtil.takeScreenShot(driver, contactHeader);

	}
}
