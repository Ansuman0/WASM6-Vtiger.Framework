package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

	// Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactImg;

	@FindBy(name = "firstname")
	private WebElement firstNameEdt;

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement firstNameDrp;

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;

	@FindBy(name = "search_text")
	private WebElement OrgSearchEdt;

	@FindBy(name = "search")
	private WebElement OrgSearchBtn;

	// initiliazation
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateContactLookUpImg() {
		return CreateContactImg;
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getFirstNameDrp() {
		return firstNameDrp;
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}

	// Business library
	/**
	 * This method will click on Create contact look up image
	 **/

	public void clickOnContactsLookUpImage() {
		CreateContactImg.click();
	}

	/**
	 * This method will create a new contact.
	 * 
	 * @param driver
	 * @param LASTNAME
	 */
	public void createContact(WebDriver driver, String firtname, String LASTNAME) {
		handleDropDown(firstNameDrp, "Mr.");
		firstNameEdt.sendKeys(firtname);
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}

	/**
	 * This method will create a new contact with Organization
	 * 
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createContactWithOrg(WebDriver driver, String firtname, String LASTNAME, String ORGNAME) {
		handleDropDown(firstNameDrp, "Mr.");
		firstNameEdt.sendKeys(firtname);
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}

}
