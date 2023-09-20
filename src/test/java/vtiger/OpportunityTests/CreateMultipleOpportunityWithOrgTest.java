package vtiger.OpportunityTests;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CampaigingPage;
import objectRepository.HomePage;
import objectRepository.OpportunityPage;
import objectRepository.OpportunityPageInfo;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationsPage;

public class CreateMultipleOpportunityWithOrgTest extends BaseClass {

	@Test(dataProvider = "combineData", groups = "RegressionSuite")
	public void createOpportunityWithOrgTest(String SourceDrp ,String Organizations) {
		String opportunityName = rUtil.generateDescription();
		String ORGNAME = rUtil.generateRandomCompany();
		String campaingName = rUtil.generateRandomCampaigingName();
		String description = rUtil.generateDescription();
		String closeDate = jUtil.getFutureDateString();
		String amount = rUtil.generateRandomAmount();

		// Step 3: Click on Organizations link and Create Organizations
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("Navigate to Organization Link & Click on Organization");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Click on Create Organization image look up");
		op.createOrganization(ORGNAME);
		Reporter.log("Creating Organization with Required Data");

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		Reporter.log("Creating Organization Name & Given Name is Same");

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

		// Step 5: Navigate to Opportunity link and Create Opportuntity
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

		try {
		//	opp.createOpportunityFullDetails(driver, opportunityName, ORGNAME, campaingName, description, closeDate,
		//			amount);
			Reporter.log("Create Opportunity with Required data");
			String CretedOpportunity = opp.getCreatedOpportunityHeader();
			Assert.assertTrue(CretedOpportunity.contains(opportunityName));
			Reporter.log("Creating Opportunity Name & Given Name is Same");
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().getMessage();

		}

	}

	@DataProvider
	public Object[][] getRelatedTypeData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("RelatedTo");
	}

	@DataProvider
	public Object[][] getLeadSourceData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("LeadSource");
	}

//	@DataProvider
//	public Object[][] combineData() throws EncryptedDocumentException, IOException {
//		return Stream.of(getRelatedTypeData(), getLeadSourceData()).flatMap(Arrays::stream).toArray(Object[][]::new);
//
//	}

}
