package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class VendorsPageInfo extends WebDriverUtility {

	@FindBy(xpath = "//td[@class='moduleName']")
	private WebElement vendorsPageHederText;

	public VendorsPageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorsPageHederText() {
		return vendorsPageHederText;
	}

	public String getVendorsPageHeader() {
		return getVendorsPageHederText().getText();
	}

}
