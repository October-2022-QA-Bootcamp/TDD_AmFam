package amfam.tdd.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer{

	int limit = 2;
	int alreadyTried = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(alreadyTried < limit) {
			alreadyTried++;
			return true;
		}
		return false;
	}

}
