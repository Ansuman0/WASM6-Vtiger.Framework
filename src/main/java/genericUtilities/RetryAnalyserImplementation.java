package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation for the IRetryAnalyser
 * 
 * @author Ansuman
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	int count = 0;
	int retryCount = 4;

	// fail
	public boolean retry(ITestResult result) {

		while (count < retryCount) // 0<4/1<4/2<4/3<4/4<4 - no
		{
			count++; // 1/2/3/4
			return true; // retry/retry/retry/retry

		}

		return false;
	}

}
