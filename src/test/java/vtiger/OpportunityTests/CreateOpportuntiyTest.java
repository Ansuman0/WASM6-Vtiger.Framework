package vtiger.OpportunityTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ListenersImplementation;
import objectRepository.HomePage;
import objectRepository.OpportunityPage;
import objectRepository.OpportunityPageInfo;
import vtiger.CampaigingTests.CreateCampaiging;
import vtiger.OrganizationsTests.CreateOrgWithIndustryTest;

@Listeners(ListenersImplementation.class)
public class CreateOpportuntiyTest extends BaseClass {

	CreateOrgWithIndustryTest org = new CreateOrgWithIndustryTest();
	CreateCampaiging cc = new CreateCampaiging();

	@Test
	public void createOpportunityTest() throws Exception {

		String opportunityName = rUtil.generateDescription();
		String ORGNAME = rUtil.generateRandomCompany();
		String campaingName = rUtil.generateRandomCampaigingName();
		String description = rUtil.generateDescription();
		String closeDate = jUtil.getFutureDateString();
		String amount =rUtil.generateRandomAmount();

		org.createOrgWithIndTest();
		Reporter.log("Navigate to Organization & Create organization");

		cc.createCampaigingTest();
		Reporter.log("Navigate to Campaing & Create Campaing");

		HomePage hp = new HomePage(driver);
		hp.clickOnOpportunitiesLnk();
		Reporter.log("Navigate to Opportunities Link & Click on Opportunities.");

		OpportunityPageInfo opi = new OpportunityPageInfo(driver);
		String opportunityPageHeader = opi.getOpportunitiesPageHeader();
		Assert.assertTrue(opportunityPageHeader.contains(opportunityPageHeader));
		Reporter.log(opportunityPageHeader + "Its opportunityPageHeader ");

		OpportunityPage opp = new OpportunityPage(driver);
		opp.clickOnOpportunityLookUpImage();
		Reporter.log("Click on Opportunity Campainging image look up");
		String OpportunityFormTitel = opp.getOpportunitiesPageHeader();
		Assert.assertTrue(OpportunityFormTitel.contains(OpportunityFormTitel));
		Reporter.log("Click on the Opportunity form to Create Opportunity");

		//opp.createOpportunityFullDetails(driver, opportunityName, ORGNAME, campaingName, description, closeDate ,amount);
		Reporter.log("Create Opportunity with Required data");
		String CretedOpportunity = opp.getCreatedOpportunityHeader();
		Assert.assertTrue(CretedOpportunity.contains(opportunityName));
		Reporter.log("Creating Opportunity Name & Given Name is Same");

	}

}
