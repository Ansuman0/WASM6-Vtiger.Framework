package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CampaigingPage extends WebDriverUtility {
	WebDriver driver;
	@FindBy(css = "[alt='Create Campaign...']")
	private WebElement createCampaigingLookUpImg;

	@FindBy(className = "lvtHeaderText")
	private WebElement campaingingFormHeaderText;

	@FindBy(name = "campaignname")
	private WebElement campaignNameEdt;

	@FindBy(name = "campaigntype")
	private WebElement campaigntypeDrp;

	@FindBy(name = "closingdate")
	private WebElement expectedCloseDate;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement CreatedCampaignHeaderTitel;

	// initialization

	public CampaigingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getCreateCampaigingLookUpImg() {
		return createCampaigingLookUpImg;
	}

	public WebElement getCampaingingFormHeaderText() {
		return campaingingFormHeaderText;
	}

	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}

	public WebElement getCampaigntypeDrp() {
		return campaigntypeDrp;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCreatedCampaignHeaderTitel() {
		return CreatedCampaignHeaderTitel;
	}

	// Business Library

	/**
	 * This method will click on Create Campaiging look up image
	 */
	public void clickOnCampaigingLookUpImage() {
		getCreateCampaigingLookUpImg().click();
	}

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getCampaigingFormHeader() {
		return getCampaingingFormHeaderText().getText();
	}

	public void createCampaiging(WebDriver driver, String campaingName, String campaignType, String closeDate) {
		getCampaignNameEdt().sendKeys(campaingName);
		handleDropDown(getCampaigntypeDrp(), campaignType);
		getExpectedCloseDate().clear();
		getExpectedCloseDate().sendKeys(closeDate);
		getSaveBtn().click();

	}

	public void createNewCampaiging(WebDriver driver, String campaingName, String closeDate) {
		getCampaignNameEdt().sendKeys(campaingName);
		// handleDropDown(getCampaigntypeDrp(), campaignType);
		getExpectedCloseDate().clear();
		getExpectedCloseDate().sendKeys(closeDate);
		getSaveBtn().click();

	}

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getCreatedCampaignHeader() {
		return getCreatedCampaignHeaderTitel().getText();
	}

}
