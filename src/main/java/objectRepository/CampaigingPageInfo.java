package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CampaigingPageInfo extends WebDriverUtility {

	@FindBy(xpath = "//td[@class='moduleName']")
	private WebElement CampaignPageHederText;

	public CampaigingPageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignPageHederText() {
		return CampaignPageHederText;
	}
	
	public String getCreatedCampaignHeader() {
		return getCampaignPageHederText().getText();
	}
}
