package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.ListenersImplementation;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * @author Chaitra M
 */
@Epic("Web Application Regression Testing")
@Feature("Login Page Tests")
@Listeners(ListenersImplementation.class)
public class LoginPage { // rule 1: create class

	// Rule 2: identify the element using annotations
	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindAll({ @FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement loginBtn;

	// Rule 3: Create a constructor to initiliaze
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	// Rule 4: Provide getters to access
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Business Libraries - project specific generic utilities
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	@Severity(SeverityLevel.BLOCKER)
    @Description("Test Description : After successful login to application opens Home page")
    @Story("Successful login of application opens Dashboard Page")
    public void loginToApp(String USERNAME, String PASSWORD)
    {
    	userNameEdt.sendKeys(USERNAME);
    	passwordEdt.sendKeys(PASSWORD);
    	loginBtn.click();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
