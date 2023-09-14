package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPageInfo {

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesHederText;

	public OpportunityPageInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunitiesPageHederText() {
		return OpportunitiesHederText;
	}

	public String getOpportunitiesPageHeader() {
		return getOpportunitiesPageHederText().getText();
	}
}
