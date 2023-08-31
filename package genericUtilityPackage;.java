package genericUtilityPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to web driver actions
 * 
 * @author Ansuman
 *
 */
public class WebDriverLibrary {

	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for 20 seconds to load the page
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20L));
	}

	/**
	 * This method will wait for 10 seconds for element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

	/**
	 * This method will wait for 10 seconds for the element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This is a custom wait which is used to wait for element and perform click
	 * action
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickOnElement(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 10) {
			try {
				element.click();
				break;

			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method will handle drop-down through select class and select data by
	 * index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method will handle drop-down through select class and select data by
	 * value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method will handle drop-down through select class and select data by
	 * visible text
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method will perform mouse hover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform right click on the web page
	 * 
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method will perform right click on a particular web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform double click on web page
	 * 
	 * @param driver
	 */
	public void doubleClickOn(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method will perform double click on a particular web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will drag and drop from source element to destination element
	 * 
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropOn(WebDriver driver, WebElement srcElement, WebElement dstElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).perform();
	}

	/**
	 * This is method will mouse hover using offset value for x and y co-ordinates.
	 * 
	 * @param driver
	 * @param xOff
	 * @param yOff
	 */
	public void mouseHoverOn(WebDriver driver, int xOff, int yOff) {
		Actions act = new Actions(driver);
		act.moveByOffset(xOff, yOff).perform();
	}

	/**
	 * This method will switch to frame based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch to frame based on name or id
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method will switch to frame based on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will switch from current frame to immediate parent
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method will switch from current frame to default frame
	 * 
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will click accept in alert pop up
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will click on cancel in alert pop up
	 * 
	 * @param driver
	 */
	public void dismisAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will return the text of alert pop up to the caller
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}

	/**
	 * This method will press the enter key
	 * 
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will switch from parent window to any child window or from any
	 * child window to parent window based on the partial window title.
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		// Step 1: get all the window handles
		Set<String> windowIds = driver.getWindowHandles();

		// Step 2: iterate through all the window ids --- similar to foreach loop
		Iterator<String> it = windowIds.iterator();

		// Step 3: navigate to each window and check the title
		while (it.hasNext()) {
			// Step 4: capture the individual window id
			String winID = it.next();

			// Step 5: switch to that window and capture the title
			String currentTitle = driver.switchTo().window(winID).getTitle();

			// Step 6: compare current title with partial title
			if (currentTitle.contains(partialWindowTitle)) {
				break;
			}
		}

	}

	/**
	 * This method will take the screen shot
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\" + screenshotName + ".png");
		FileUtils.copyFile(src, dst); // from commons io

		return dst.getAbsolutePath(); // used for extends reports

	}

	/**
	 * public static void takeSnapShot(WebDriver webdriver,String fileWithPath)
	 * throws Exception{ //Convert web driver object to TakeScreenshot
	 * TakesScreenshot scrShot =((TakesScreenshot)webdriver); //Call getScreenshotAs
	 * method to create image file File
	 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE); //Move image file to new
	 * destination File DestFile=new File(fileWithPath); //Copy file at destination
	 * FileUtils.copyFile(SrcFile, DestFile); }
	 **/

	/**
	 * This method will scroll down for 500 units
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	/**
	 * This method will scroll untill the specified element is found
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView();", element);

		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}

}
