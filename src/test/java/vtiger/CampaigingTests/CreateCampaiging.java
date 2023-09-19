package vtiger.CampaigingTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
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
@Feature("Create  Campaiging without Campaiging Type")
@Listeners(ListenersImplementation.class)
public class CreateCampaiging extends BaseClass {

	@Test
	public void createCampaigingTest() {

		String campaingName = rUtil.generateRandomCampaigingName();
		String closeDate = jUtil.getFutureDateString();
		System.out.println("Date :" + closeDate);

		HomePage hp = new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnCampaignLnk(driver);

		CampaigingPageInfo cpi = new CampaigingPageInfo(driver);
		String campaigingPageHeader = cpi.getCreatedCampaignHeader();
		Assert.assertTrue(campaigingPageHeader.contains(campaigingPageHeader));

		CampaigingPage cp = new CampaigingPage(driver);
		cp.clickOnCampaigingLookUpImage();

		String capaiginFormTitle = cp.getCampaigingFormHeader();
		Assert.assertTrue(capaiginFormTitle.contains(capaiginFormTitle));

		cp.createNewCampaiging(driver, campaingName, closeDate);
		String createdCapaiginTitel = cp.getCreatedCampaignHeader();
		Assert.assertTrue(createdCapaiginTitel.contains(createdCapaiginTitel));

	}

}
