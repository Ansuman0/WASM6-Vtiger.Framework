package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {

	// Declaration

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;

	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;

	@FindBy(name = "industry")
	private WebElement IndustryDropDwn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	// initializations
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	//Business LIbrary

	/**
	 * This method will click on create contact look up image
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		CreateOrgLookUpImg.click();
	}
	
	/**
	 * This method will create a organization
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create a  organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrganizationWithInd(String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDwn, INDUSTRY);
		SaveBtn.click();
	}
	
	
	
	
	
}