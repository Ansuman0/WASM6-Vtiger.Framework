package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.qameta.allure.Attachment;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ---- Test Execution Started ----"); // Overriding //abstraction

		test = report.createTest(methodName);
		test.log(Status.INFO, methodName + " -> execution started");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ---- Test Execution successfull ----");

		test.log(Status.PASS, methodName + " -> PASS");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// saveScreenshot(result.getName(), BaseClass.sDriver);
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ---- Test Execution Failed ----");
		System.out.println(result.getThrowable());

		test.log(Status.FAIL, methodName + " -> FAIL");
		test.log(Status.WARNING, result.getThrowable());

		// Take - Screenshot
		String screenShotName = methodName + "-" + new JavaUtility().getSystemInFormat();
		WebDriverUtility wLib = new WebDriverUtility();
		try {

			String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " ---- Test Execution skipped ----");
		System.out.println(result.getThrowable());

		test.log(Status.SKIP, methodName + " -> SKIP");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);

	}

	public void onStart(ITestContext context) {

		System.out.println("---- Execution Started ----");

		// Configure the extent Reports
		ExtentSparkReporter html = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemInFormat() + ".html");
		html.config().setDocumentTitle("Vtiger Execution Report");
		html.config().setReportName("Execution report BuildV2.3.1");
		html.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "http://localhost:8888/");
		report.setSystemInfo("Base Platform", "Windows - 11");
		report.setSystemInfo("Reporter Name", "Ansuman");

	}

	public void onFinish(ITestContext context) {

		System.out.println("---- Execution finished ----");

		report.flush(); // is responsible for report generation.

	}
	/**
	 * @Attachment(value = "Screenshot of {0}", type = "image/png") public byte[]
	 *                   saveScreenshot(String name, WebDriver driver) { return
	 *                   (byte[]) ((TakesScreenshot)
	 *                   driver).getScreenshotAs(OutputType.BYTES); }
	 **/

}
