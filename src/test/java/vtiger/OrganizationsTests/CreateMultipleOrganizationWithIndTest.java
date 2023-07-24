package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;
/**
 * @author Ansuman
 **/

public class CreateMultipleOrganizationWithIndTest extends BaseClass{
	

	@Test(dataProvider = "getData")
	public void createOrgTEst(String ORG, String INDUSTRY) throws IOException {

		String ORGNAME = ORG+jUtil.getRandomNumber();
		
		WebDriver driver = null;


		// Step 3: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 4: Click on Create Org Look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 5: Create Organization with mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeader();
        Assert.assertTrue(orgHeader.contains(ORGNAME));
		

	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("DatProviderOrg");
	}

}
