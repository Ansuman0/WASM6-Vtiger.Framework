package vtiger.CampaigingTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.JavaUtility;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Feature;
import objectRepository.CampaigingPage;
import objectRepository.CampaigingPageInfo;
import objectRepository.HomePage;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */
@Feature("Create Multiple Campaiging with Campaiging Type")
@Listeners(ListenersImplementation.class)
public class CreateMultipleCampaiging extends BaseClass {

	@Parameters("browser")
	@Test(dataProvider = "getData", groups = "RegressionSuite")
	public void createCampaigingTest(String campaignType) {

		String campaingName = jUtil.generateRandomCampaigingName();
		String closeDate = JavaUtility.getFutureDateString();
		System.out.println("Date :"+closeDate);

		HomePage hp = new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnCampaignBtn(driver);

		CampaigingPageInfo cpi = new CampaigingPageInfo(driver);

		String campaigingPageHeader = cpi.getCreatedCampaignHeader();
		Assert.assertTrue(campaigingPageHeader.contains(campaigingPageHeader));

		CampaigingPage cp = new CampaigingPage(driver);
		cp.clickOnCampaigingLookUpImage();

		String capaiginFormTitle = cp.getCampaigingFormHeader();
		Assert.assertTrue(capaiginFormTitle.contains(capaiginFormTitle));

		cp.createCampaiging(driver, campaingName, campaignType, closeDate);

		String createdCapaiginTitel = cp.getCreatedCampaignHeader();
		Assert.assertTrue(createdCapaiginTitel.contains(createdCapaiginTitel));

	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("DatProviderCampaiging");
	}

}
