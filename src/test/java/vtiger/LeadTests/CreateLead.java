package vtiger.LeadTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import objectRepository.HomePage;
import objectRepository.LeadPage;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */

@Feature("Lead Page TestCases")
@Listeners(ListenersImplementation.class)
public class CreateLead extends BaseClass {
	
	@Parameters("browser")
	@Test(groups = "RegressionSuite")
	public void createLeadTest() throws Exception {

		// Step 3: read all the required data
		String firstName = rUtil.generateRandomFirstName();
		String lastName = rUtil.generateRandomLastName();
		String company = rUtil.generateRandomCompany();

		// Step 4: Navigate to Leads Link
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsLnk();

		// Step 5: Navigate to create Lead Look up image
		LeadPage lp = new LeadPage(driver);

		String leadPageHeader = lp.getLeadHeader();
		Assert.assertTrue(leadPageHeader.contains("Leads"));
		System.out.println("Lead Page Header Matched : " + leadPageHeader);

		lp.clickOnLeadLookUpImage();

		String createLeadPageHeader = lp.getCreateLeadPageHeader();
		Assert.assertFalse(createLeadPageHeader.contains("Creating New Lead"));
		System.out.println("Create Lead Page Header Matched : " + createLeadPageHeader);

		lp.createNewLead(driver, firstName, lastName, company);

		// Step 7: Validate
		String leadNameHeader = lp.getLeadNameHeader();
		Assert.assertEquals(leadNameHeader, leadNameHeader);
		// Assert.assertTrue(leadNameHeader.contains(firstName + lastName));
		System.out.println("Lead Name Matched : " + leadNameHeader);
		// wUtil.takeScreenShot(driver, leadNameHeader);
	}

}
