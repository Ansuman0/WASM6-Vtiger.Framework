package vtiger.ContactsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
/**
 * @author Ansuman
 */

public class CreateContactWithOrganizationTest extends BaseClass {

    @Test(groups = "RegressionSuite")
    public void createContactWithOrgTest() throws Exception
	{

		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);

		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 5: Create Organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		// Step 6: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));//fail

		// Step 7: Navigate to Contacts link
		hp.clickOnContactsLink();

		// Step 8: click on create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactsLookUpImage();

		// Step 9: Create Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);

		// Step 10: Validate for Organization
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		
		
	}

    
    @Test
    public void demo()
    {
    	System.out.println("This is demo");
    }
}
