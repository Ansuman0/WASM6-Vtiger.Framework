package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Feature;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */
@Feature("Create Multiple Organization With Industry Test")
@Listeners(ListenersImplementation.class)
public class CreateMultipleOrganizationWithIndTest extends BaseClass {

	@Test(dataProvider = "getData", groups = "RegressionSuite")
	public void createOrgTEst(/* String ORG, */ String INDUSTRY) throws IOException {

		/*
		 * ORG is commed out .which will read data from execl.
		 */
		String ORGNAME = /* ORG+ */rUtil.generateRandomCompany();

//		WebDriver driver = null;

		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 5: Create Organization with mandatory fields
		OrganizationsPage cnop = new OrganizationsPage(driver);
		cnop.createOrganizationWithInd(ORGNAME, INDUSTRY);

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));

	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("DataProviderIndustryType");
	}

}
