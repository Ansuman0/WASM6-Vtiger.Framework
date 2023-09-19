package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

/**
 * 
 */
public class ProductPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement CreateProductLookUpImg;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductFormHeaderText;

	@FindBy(name = "productname")
	private WebElement ProductNameEdt;

	@FindBy(xpath = "//input[@name='sales_start_date']")
	private WebElement ProductDateEdt;

	@FindBy(name = "productcategory")
	private WebElement ProductCategoryDrp;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement CreatedProductHeaderTitel;

	// initialization

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public WebElement getCreateProductLookUpImg() {
		return CreateProductLookUpImg;
	}

	public WebElement getProductFormHeaderText() {
		return ProductFormHeaderText;
	}

	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}

	public WebElement getProductDateEdt() {
		return ProductDateEdt;
	}

	public WebElement getProductCategoryDrp() {
		return ProductCategoryDrp;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCreatedProductHeaderTitel() {
		return CreatedProductHeaderTitel;
	}

	// Business Library

	/**
	 * This method will click on Create Product look up image
	 */
	public void clickOnProductLookUpImage() {
		getCreateProductLookUpImg().click();
	}

	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getProductFormHeader() {
		return getProductFormHeaderText().getText();
	}

	public void createProduct(WebDriver driver, String productName, String produtStartDate, String productCategory) {

		getProductNameEdt().sendKeys(productName);
		getProductDateEdt().sendKeys(produtStartDate);
		handleDropDown(getProductCategoryDrp(), productCategory);
		getSaveBtn().click();
	}
	/**
	 * This method will get the header text
	 * 
	 * @return
	 */
	public String getCreateddProduct() {
		return getCreatedProductHeaderTitel().getText();
	}

}
