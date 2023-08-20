package genericUtilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface
 * 
 * @author Ansuman
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	private static final Logger Log = Logger.getLogger(ListenersImplementation.class.getName());

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		Log.info(methodName + " ---- Test Execution Started ----"); // Overriding //abstraction

		test = report.createTest(methodName);
		test.log(Status.INFO, methodName + " -> execution started");

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		Log.info(methodName + " ---- Test Execution successfull ----");

		test.log(Status.PASS, methodName + result.getTestName() + " -> PASS");
		test.log(Status.INFO, methodName + result.getTestName() + " -> PASS");

		/*
		 * // Take - Screenshot String screenShotName = methodName + "-" + new
		 * JavaUtility().getSystemInFormat(); WebDriverUtility wLib = new
		 * WebDriverUtility(); try {
		 * 
		 * String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
		 * test.addScreenCaptureFromPath(path); } catch (IOException e) {
		 * e.printStackTrace(); e.getCause(); }
		 */

	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		Log.info(methodName + " ---- Test Execution Failed ----");

		Log.info(result.getThrowable()+ result.getName());

		test.log(Status.FAIL, methodName + result.getTestName() + " -> FAIL");
		test.log(Status.WARNING, result.getThrowable().toString());
		test.log(Status.INFO, methodName + result.getTestName() + " -> FAIL");

		// Take - Screenshot
		String screenShotName = methodName + "-" + new JavaUtility().getSystemInFormat();
		WebDriverUtility wLib = new WebDriverUtility();
		try {

			String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);

		} catch (IOException e) {
			e.printStackTrace();
			e.getCause();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		Log.info(methodName + result.getTestName() + " ---- Test Execution skipped ----");
		Log.info(result.getThrowable() + result.getTestName());

		test.log(Status.SKIP, methodName + result.getTestName() + " -> SKIP");
		test.log(Status.INFO, methodName + result.getTestName() + " -> SKIP");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		((ITestListener) test).onTestFailedButWithinSuccessPercentage(result);
		Log.info(methodName + result.getTestName() + "Test failed but it is in defined success ratio ");
		test.log(Status.INFO, methodName + result.getTestName() + " -> Test failed but it is in defined success ratio");

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);

	}

	@Parameters({ "OS", "browser" })
	public void onStart(ITestContext context) {

		Log.info("---- Execution Started ----");

		// Configure the extent Reports

		ExtentSparkReporter html = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemInFormat() + ".html");

		html.config().setDocumentTitle("Vtiger Execution Report");
		html.config().setReportName("Execution report BuildV2.3.1");
		html.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		html.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "http://localhost:8888/");
		report.setSystemInfo("Base Platform", "Windows - 11");
		// report.setSystemInfo("Reporter Name", "Ansuman");

	}

	public void onFinish(ITestContext context) {

		Log.info("---- Execution finished ----");

		report.flush(); // is responsible for report generation.

	}

}
