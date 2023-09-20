package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class VendorsPage extends WebDriverUtility {

	@FindBy(css = "[alt='Create Vendor...']")
	private WebElement createVendorsLookUpImg;

	@FindBy(className = "lvtHeaderText")
	private WebElement vendorsFormHeaderText;

	/**
	 * Vendor Information:
	 */
	@FindBy(name = "vendorname")
	private WebElement vendorNameEdt;

	@FindBy(id = "email")
	private WebElement emailTextEdt;

	@FindBy(xpath = "//select[@name='glacct']")
	private WebElement gLAccountDrp;

	@FindBy(id = "category")
	private WebElement categoryTextEdt;

	@FindBy(id = "phone")
	private WebElement phoneNumberTextEdt;

	@FindBy(name = "website")
	private WebElement websiteTextEdt;

	/**
	 * Address Information:
	 */
	@FindBy(name = "street")
	private WebElement AddressEdt;

	/**
	 * Description Name:
	 */
	@FindBy(xpath = "//*[contains(@name,'description')]")
	private WebElement descriptionEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement CreatedVendorsHeaderTitel;

	// initialization

	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getCreateVendorsLookUpImg() {
		return createVendorsLookUpImg;
	}

	public WebElement getVendorsFormHeaderText() {
		return vendorsFormHeaderText;
	}

	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
	}

	public WebElement getEmailTextEdt() {
		return emailTextEdt;
	}

	public WebElement getGLAccountDrp() {
		return gLAccountDrp;
	}

	public WebElement getCategoryTextEdt() {
		return categoryTextEdt;
	}

	public WebElement getPhoneNumberTextEdt() {
		return phoneNumberTextEdt;
	}

	public WebElement getWebsiteTextEdt() {
		return websiteTextEdt;
	}

	public WebElement getAddressEdt() {
		return AddressEdt;
	}

	public WebElement getDetailedTextBox() {
		return descriptionEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCreatedVendorsHeaderTitel() {
		return CreatedVendorsHeaderTitel;
	}

	// Business Library

	/**
	 * This method will click on Create Vendors look up image
	 */
	public void clickOnVendorsookUpImage() {
		getCreateVendorsLookUpImg().click();
	}

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getVendorsFormHeader() {
		return getVendorsFormHeaderText().getText();
	}

	/**
	 * This method will create vendors with multiplue GL-Account Type.
	 * 
	 * @param driver
	 * @param vendorName
	 * @param email
	 * @param category
	 * @param phoneNumber
	 * @param webSite
	 * @param address
	 * @param description
	 */
	public void createVendorsSingleGLaccount(WebDriver driver, String vendorName, String email, String category,
			String phoneNumber, String webSite, String address, String description) {

		// Vendor Information:
		getVendorNameEdt().sendKeys(vendorName);
		getEmailTextEdt().sendKeys(email);
		getCategoryTextEdt().sendKeys(category);
		getPhoneNumberTextEdt().sendKeys(phoneNumber);
		getWebsiteTextEdt().sendKeys(webSite);

		// Address Information:
		getAddressEdt().sendKeys(address);

		// Description Name:
		scrollAction(driver);
		waitForElementToBeVisisble(driver, descriptionEdt);
		getDetailedTextBox().sendKeys(description);

		// save
		mouseHoverAction(driver, SaveBtn);

		getSaveBtn().click();
	}

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getCreatedVendorsHeader() {
		return getCreatedVendorsHeaderTitel().getText();
	}

	/**
	 * This method will create vendors with multiplue GL-Account Type.
	 * 
	 * @param driver
	 * @param vendorName
	 * @param email
	 * @param gLAccount
	 * @param category
	 * @param phoneNumber
	 * @param webSite
	 * @param address
	 * @param description
	 */

	public void createVendorsMultipuleGLaccount(WebDriver driver, String vendorName, String email, String gLAccount,
			String category, String phoneNumber, String webSite, String address, String description) {

		// Vendor Information:
		getVendorNameEdt().sendKeys(vendorName);
		getEmailTextEdt().sendKeys(email);
		handleDropDown(getGLAccountDrp(), gLAccount);
		getCategoryTextEdt().sendKeys(category);
		getPhoneNumberTextEdt().sendKeys(phoneNumber);
		getWebsiteTextEdt().sendKeys(webSite);

		// Address Information:
		getAddressEdt().sendKeys(address);

		// Description Name:
		scrollAction(driver);
		waitForElementToBeVisisble(driver, descriptionEdt);
		getDetailedTextBox().sendKeys(description);

		// save
		mouseHoverAction(driver, SaveBtn);
		getSaveBtn().click();

	}

}
