package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	// declaration

	@FindBy(xpath = "//td[@class='moduleName']")
	private WebElement HomepageHeader;

	@FindBy(linkText = "Leads")
	private WebElement LeadsLnk;

	@FindBy(linkText = "Leads")
	private WebElement LeadPageTitel;

	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;

	@FindBy(linkText = "Products")
	private WebElement ProductLnk;

	@FindBy(linkText = "More")
	private WebElement moreLnk;

	@FindBy(name = "Campaigns")
	private WebElement campaignLnk;

	@FindBy(name = "Vendors")
	private WebElement vendorsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;

	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getHomepageHeader() {
		return HomepageHeader;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getLeadPageTitel() {
		return LeadPageTitel;
	}

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProdutsLnk() {
		return ProductLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCampaignLnk() {
		return campaignLnk;
	}

	public WebElement getVendorsLnk() {
		return vendorsLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	// Business Library

	/**
	 * This method will get Home page Header Text
	 */

	public String homePageTitel() {

		return HomepageHeader.getText();

	}

	/**
	 * This method will click on Leads link
	 */
	public void clickOnLeadsLnk() {
		LeadsLnk.click();

	}

	/**
	 * This method will get the Lead page header text
	 * 
	 * @return
	 */
	public String leadPageTitel() {
		return LeadPageTitel.getText();

	}

	/**
	 * This method will click on Organizations link
	 */
	public void clickOnOrganizationLink() {
		OrganizationsLnk.click();
	}

	/**
	 * This method will click on Contacts link
	 * 
	 * @throws Exception
	 */
	public void clickOnContactsLink() throws Exception {
		ContactsLnk.click();
	}

	/**
	 * This method will click on Opportunities link
	 * 
	 */
	public void clickOnOpportunitiesLnk() {
		OpportunitiesLnk.click();
	}

	/**
	 * This method will click on Products link
	 * 
	 **/
	public void clickOnProductsLink() {
		ProductLnk.click();
	}

	/**
	 * This will click on MoreLink Icon and Move to Click on campaignBtn.
	 */

	public void clickOnMoreLink() {
		moreLnk.click();
	}

	public void clickOnCampaignLnk(WebDriver driver) {
		moreLnk.click();
		waitForElementToBeVisisble(driver, campaignLnk);
		campaignLnk.click();
	}

	public void clickOnVendorsLnk(WebDriver driver) {
		moreLnk.click();
		waitForElementToBeVisisble(driver, vendorsLnk);
		vendorsLnk.click();
	}

	/**
	 * This method will logout of the application
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void logOutOfApp(WebDriver driver) {
		mouseHoverAction(driver, AdministratorImg);
		waitForElementToBeVisisble(driver, SignOutLnk);

		Boolean actualElement = true;
		while (actualElement) {
			try {
				SignOutLnk.click();
				actualElement = false;
			} catch (Exception e) {
				actualElement = true;
			}
		}
	}
}
