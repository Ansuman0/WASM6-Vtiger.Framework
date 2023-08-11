package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class ContactsPage extends WebDriverUtility{

	// declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;

	// initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}

	
	//Business Library
	/**
	 * This method will click on Create contact look up image
	 */
	public void clickOnContactsLookUpImage() 
	{
		CreateContactLookUpImg.click();
	}
}
