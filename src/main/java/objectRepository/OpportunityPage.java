package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class OpportunityPage extends WebDriverUtility {

	// Opportunity Information:
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement CreateOpportunityLookUpImg;

	@FindBy(xpath = "//span[contains(text(), 'Creating New Opportunity')]")
	private WebElement OpportunitFormHeader;

	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement OpportunityNameEdt;

	@FindBy(xpath = "//select[@id='related_to_type']")
	private WebElement RelatedToDrp;

	@FindBy(xpath = "//input[@name='related_to_display']/following-sibling::Img[@title='Select']")
	private WebElement RelatedToDrpValueLookUpImg; // Related To values based on dropDown
													// Selection(Organiztions,Contacts)
	/*
	 * This will open another windows where we can open Organization
	 */
	@FindBy(name = "search_text")
	private WebElement OrgSearchEdt;

	@FindBy(name = "search")
	private WebElement OrgSearchBtn;

	@FindBy(xpath = "//select[@name='opportunity_type']")
	private WebElement OpportunityTypeDrp;

	@FindBy(name = "leadsource")
	private WebElement LeadSourceDrp;

	@FindBy(xpath = "//select[@name='assigned_user_id']") // have to select Based on Value as ts Madatoryfield**
	private WebElement AssignedToDrp;

	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::Img[@title='Select']")
	private WebElement CampaignSourceLookUpImg; // Campaign Source

	@FindBy(name = "amount")
	private WebElement Amount;

	@FindBy(name = "closingdate")
	private WebElement expectedCloseDate;

	@FindBy(name = "sales_stage")
	private WebElement SalesStageDrp;

	@FindBy(xpath = "//textarea[@class='detailedViewTextBox']")
	private WebElement descriptionEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement CreatedOpportunityHeaderTitel;

	// initialization
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateOpportunityLookUpImg() {
		return CreateOpportunityLookUpImg;
	}

	public WebElement getOpportunityHeaderText() {
		return OpportunitFormHeader;
	}

	public WebElement getOpportunityNameEdt() {
		return OpportunityNameEdt;
	}

	public WebElement getRelatedToDrp() {
		return RelatedToDrp;
	}

	public WebElement getRelatedToDrpValueLookUpImg() {
		return RelatedToDrpValueLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOpportunityTypeDrp() {
		return OpportunityTypeDrp;
	}

	public WebElement getLeadSourceDrp() {
		return LeadSourceDrp;
	}

	public WebElement getAssignedToDrp() {
		return AssignedToDrp;
	}

	public WebElement getCampaignSourceLookUpImg() {
		return CampaignSourceLookUpImg;
	}

	public WebElement getAmount() {
		return Amount;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getSalesStageDrp() {
		return SalesStageDrp;
	}

	public WebElement getDescriptionEdt() {
		return descriptionEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCreatedOpportunityHeaderTitel() {
		return CreatedOpportunityHeaderTitel;
	}

	// Business library
	/**
	 * This method will click on Create contact look up image
	 **/

	public void clickOnOpportunityLookUpImage() {
		getCreateOpportunityLookUpImg().click();

	}

	/**
	 * This method will get the Create Opportunity Form Page Titel
	 */
	public String getOpportunitiesPageHeader() {
		return getOpportunityHeaderText().getText();
	}

	public void createOpportunityFullDetails(WebDriver driver, String opportunityName, String ORGNAME,
			String CampaignsName, String description, String closeDate) {

		getOpportunityNameEdt().sendKeys(opportunityName);

		/*
		 * I have Taken staic Value ,If require dynami value can use data Provider.
		 * Based on the related Dropdown value we are selecting this . This will switch
		 * windows and move Organization window and select Created Org.
		 */
		handleDropDown(getRelatedToDrp(), "Accounts");// Organizations
		getRelatedToDrpValueLookUpImg().click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		switchToWindow(driver, "Potentials");// opportunity page.

		/*
		 * I have Taken staic Value ,If require dynami value can use data Provider.
		 */
		handleDropDown(getOpportunityTypeDrp(), "Existing Business");

		/*
		 * I have Taken staic Value ,If require dynami value can use data Provider.
		 * 
		 * Based on the related Dropdown value we are selecting this . This will switch
		 * windows and move Campaingn window and select Created Org. Base on the Created
		 * Camapign we passing this value.
		 */
		handleDropDown(getLeadSourceDrp(), "Cold Call");
		getCampaignSourceLookUpImg().click();
		switchToWindow(driver, "Campaigns");// campaigns
		OrgSearchEdt.sendKeys(CampaignsName);
		driver.findElement(By.xpath("//a[.='" + CampaignsName + "']")).click();
		switchToWindow(driver, "Potentials");// opportunity page.

		getAmount().sendKeys("");
		getExpectedCloseDate().clear();
		getExpectedCloseDate().sendKeys(closeDate);

		/*
		 * I have Taken staic Value ,If require dynami value can use data Provider.
		 */

		// handleDropDown(getSalesStageDrp(), "Prospecting"); //If Required enable.

		getDescriptionEdt().sendKeys(description);
		getSaveBtn().click();

	}

	/**
	 * This method will get the Create Opportunity after save.
	 */
	public String getCreatedOpportunityHeader() {
		return getCreatedOpportunityHeaderTitel().getText();
	}
}
