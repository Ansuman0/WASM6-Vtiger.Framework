package vtiger.OrganizationsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrgWithIndustryTest extends BaseClass {

	@Parameters("browser")
	@Test(groups = "SmokeSuite")
	public void createOrgWithIndTest() throws IOException {
		/*
		 * This will read data from Excel
		 */
		// String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2) +
		// jUtil.getRandomNumber();

		/*
		 * This will Read data from Datafaker using faker class
		 */
		String ORGNAME = rUtil.generateRandomCompany();
		String INDUSTRY = eUtil.readDataFromExcel("Organization", 4, 3);

		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("Clicked on Organizations link", true);

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Click on Create Org Look Up Image", true);

		// Step 5: Create Organization with mandatory fields
		OrganizationsPage cnop = new OrganizationsPage(driver);
		cnop.createOrganizationWithInd(ORGNAME, INDUSTRY);
		Reporter.log("Organization Created with industry", true);

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));

	}
}
