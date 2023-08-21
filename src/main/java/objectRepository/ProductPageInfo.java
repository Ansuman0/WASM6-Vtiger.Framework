package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageInfo {
	
	
	@FindBy(linkText = "Products")
	private WebElement ProductPageHeaderText;
	
	public ProductPageInfo(WebDriver driver) //test script
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductPageHeaderText() {
		return ProductPageHeaderText;
	}

	//Business library
	/**
	 * This method will get the header text
	 * @return
	 */
	public String getProductPagetHeader()
	{
		return getProductPageHeaderText().getText();
	}

	

}
