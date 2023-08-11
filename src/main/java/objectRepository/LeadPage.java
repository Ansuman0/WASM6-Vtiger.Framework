package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class LeadPage extends WebDriverUtility {

	// declaration

	@FindBy(linkText = "Leads")
	private WebElement LeadsPageHeaderText;

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement CreateLeadLookUpImg;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement CreateLeadPageHeaderText;

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement FirstNameTitelDrp;

	@FindBy(name = "firstname")
	private WebElement FirstNameEdt;

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(name = "company")
	private WebElement CompanyNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement LeadHeaderText;

	// initialization

	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getLeadsPageHeaderText() {
		return LeadsPageHeaderText;
	}

	public WebElement getCreateLeadLookUpImg() {
		return CreateLeadLookUpImg;
	}

	public WebElement getCreateLeadPageHeaderText() {
		return CreateLeadPageHeaderText;
	}

	public WebElement getFirstNameTitelDrp() {
		return FirstNameTitelDrp;
	}

	public WebElement getFirstNameEdt() {
		return FirstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getCompanyNameEdt() {
		return CompanyNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getLeadHeaderText() {
		return LeadHeaderText;
	}

	// Business Library

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getLeadHeader() {
		return getLeadsPageHeaderText().getText();
	}

	/**
	 * This method will click on Create Lead look up image
	 */
	public void clickOnLeadLookUpImage() {
		getCreateLeadLookUpImg().click();
	}

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getCreateLeadPageHeader() {
		return getCreateLeadPageHeaderText().getText();
	}

	/**
	 * This method will create a new Lead.
	 * 
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewLead(WebDriver driver, String FIRSTNAME, String LASTNAME, String COMPANYNAME) {
		handleDropDown(getFirstNameTitelDrp(), "Mr.");
		getFirstNameEdt().sendKeys(FIRSTNAME);
		getLastNameEdt().sendKeys(LASTNAME);
		getCompanyNameEdt().sendKeys(COMPANYNAME);
		getSaveBtn().click();
	}

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getLeadNameHeader() {
		return getLeadHeaderText().getText();
	}
}
