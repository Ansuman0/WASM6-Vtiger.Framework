package vtiger.ContactsTests;

import org.testng.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import io.qameta.allure.Feature;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */

@Feature("Create Contact With Organization TestCases")
public class CreateContactWithOrganizationTest extends BaseClass {

	@Parameters("browser")
	@Test(groups = "RegressionSuite")
	public void createContactWithOrgTest() throws Exception {

		String ORGNAME = rUtil.generateRandomCompany();
		String firstNmame = rUtil.generateRandomFirstName();
		String LASTNAME = rUtil.generateRandomLastName();

		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 5: Create Organization with mandatory fields
		OrganizationsPage cnop = new OrganizationsPage(driver);
		cnop.createOrganization(ORGNAME);

		// Step 6: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));// fail

		// Step 7: Navigate to Contacts link
		hp.clickOnContactsLink();

		// Step 8: click on create contact look up Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnContactsLookUpImage();

		// Step 9: Create Contact
		ContactsPage cncp = new ContactsPage(driver);
		cncp.createContactWithOrg(driver, firstNmame, LASTNAME, ORGNAME);

		// Step 10: Validate for Contact 
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));

	}

}
