package vtiger.OpportunityTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import io.qameta.allure.Feature;
import objectRepository.CampaigingPage;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.HomePage;
import objectRepository.OpportunityPage;
import objectRepository.OpportunityPageInfo;

/**
 * This class provides implementation to ITestListener Interface
 * @author Ansuman
 */
@Feature("Create Opportunity with Contact all details ")
@Listeners(ListenersImplementation.class)
public class CreateOpportunityWithContactTest extends BaseClass {

	@Test
	public void createOpportunityWithContactTest() {
		String opportunityName = rUtil.generateDescription();
		String campaingName = rUtil.generateRandomCampaigingName();
		String description = rUtil.generateDescription();
		String closeDate = jUtil.getFutureDateString();
		String lastName = rUtil.generateRandomFullName();

		// Step 3: Click on Contact Link & Create on Contact
		HomePage hp = new HomePage(driver);
		try {
			hp.clickOnContactsLink();
			Reporter.log("Navigate to Contact Link & Click on Contact");
		} catch (Exception e) {
			String s = e.getCause().getMessage().toString();
			Reporter.log(s);
		}

		ContactsPage cop = new ContactsPage(driver);
		cop.clickOnContactsLookUpImage();
		Reporter.log("Click on Create Contact image look up");
		cop.createNewContact(lastName);
		Reporter.log("Creating Contact with Required Data");

		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		Assert.assertTrue(contactHeader.contains(lastName));
		Reporter.log("Created Contact & Given Contact is Same");

		// Step 4:Navigate to Campaignlink and Create Campaign
		hp.clickOnCampaignLnk(driver);
		Reporter.log("Navigate to Campaign Link & Click on Campaign.");

		CampaigingPage cp = new CampaigingPage(driver);
		cp.clickOnCampaigingLookUpImage();
		Reporter.log("Click on Create Campainging image look up");
		cp.createNewCampaiging(driver, campaingName, closeDate);
		Reporter.log("Creating Campainging with Required Data");

		String createdCapaiginTitel = cp.getCreatedCampaignHeader();
		Assert.assertTrue(createdCapaiginTitel.contains(campaingName));
		Reporter.log("Creating Campainging Name & Given Name is Same");

		// Step 5: Navigate to Opportunity link and Create Opportunity
		hp.clickOnOpportunitiesLnk();
		Reporter.log("Navigate to Opportunities Link & Click on Opportunities.");

		OpportunityPageInfo opi = new OpportunityPageInfo(driver);
		String opportunityPageHeader = opi.getOpportunitiesPageHeader();
		Assert.assertTrue(opportunityPageHeader.contains(opportunityPageHeader));
		Reporter.log(opportunityPageHeader + "Its opportunityPageHeader ");

		OpportunityPage opp = new OpportunityPage(driver);
		opp.clickOnOpportunityLookUpImage();
		Reporter.log("Click on Opportunity image look up");
		String OpportunityFormTitel = opp.getOpportunitiesPageHeader();
		Assert.assertTrue(OpportunityFormTitel.contains(OpportunityFormTitel));
		Reporter.log("Click on the Opportunity form to Create Opportunity");

		try {
			String relatedToDrp = "Contacts";
			opp.createOpportunityFullDetails(driver,opportunityName,  lastName,
					campaingName,  description,  closeDate, relatedToDrp);
			Reporter.log("Create Opportunity with Required data");
			String CretedOpportunity = opp.getCreatedOpportunityHeader();
			Assert.assertTrue(CretedOpportunity.contains(opportunityName));
			Reporter.log("Creating Opportunity Name & Given Name is Same");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().getMessage();

		}
	}

}
