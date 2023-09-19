package genericUtilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will Provide Implementation to all the abstract methods in
 * ITestlistener
 * 
 * @author Ansuman
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	private static final Logger Log = Logger.getLogger(ListenersImplementation.class.getName());

	// @Parameters({ "OS", "browser" })
	public void onTestStart(ITestResult result) {

		// run for every @Test start
		String methodName = result.getMethod().getMethodName();
		Log.info(" ---- Test Execution Started ----> " + methodName); // Overriding //abstraction

		test = report.createTest(methodName);// test script execution is started in report
		test.log(Status.INFO, methodName + " -> Test execution started");

	}

	public void onTestSuccess(ITestResult result) {
		// pass

		String methodName = result.getMethod().getMethodName();
		Log.info(methodName + " ---- Test Execution successfull ----");

		test.log(Status.PASS, methodName + result.getTestName() + " -> PASS" + Thread.currentThread().getId());
		test.log(Status.INFO, methodName + result.getTestName() + " -> PASS (Status.INFO, details)");

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
		// fail

		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();

		String methodName = result.getMethod().getMethodName() + jUtil.getSystemDateInFormat();
		Log.info(methodName + " ---- Test Execution Failed ----> " + methodName);

		Log.info(result.getThrowable() + result.getName());

		// test.log(Status.FAIL, methodName + result.getTestName() + " -> FAIL");
		test.log(Status.FAIL, " FAILED");
		test.log(Status.FAIL, result.getThrowable().toString());

		// Take - Screenshot
		// String screenShotName = methodName + "-" + new
		// JavaUtility().getSystemInFormat();
		// WebDriverUtility wLib = new WebDriverUtility();
		try {

			String path = wUtil.takeScreenShot(BaseClass.sDriver, methodName);
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

		test.log(Status.SKIP, methodName + " -> SKIP");
		test.log(Status.SKIP, result.getThrowable());

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

		Reporter.log("Execution of suite started", true);
		Log.info("---- Execution Started ----");

		// Configure the extent Reports
		// Execution of suite starts here, hence configure the extent reports here.
		// Report-11-11-2022-10-48.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateInFormat() + ".html");

		htmlReport.config().setDocumentTitle("Vtiger Test Execution Report");
		htmlReport.config().setReportName("Execution report BuildV2.3.1");
		htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		if ((context.getSuite().getParameter("value")) != null) {
			report.setSystemInfo("Base Browser", context.getSuite().getParameter("value"));
			report.setSystemInfo("Base Platform", context.getSuite().getParameter("value"));
		} else {
			report.setSystemInfo("Base Browser", "Edge");
			report.setSystemInfo("Base Platform", "Windows - 11");
		}
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888/");
		// report.setSystemInfo("Base Platform", "Windows - 11");
		report.setSystemInfo("Reporter Name", "Ansuman");

	}

	public void onFinish(ITestContext context) {

		Reporter.log("Execution of suite finished", true);
		Log.info("---- Execution finished ----");

		// Flush the report. - Here the execution is finished
		report.flush();

	}

}
