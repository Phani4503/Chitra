package Vtiger_GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This class provides Implemenation to Itestlesner interface in testng
 * @author dphan
 *
 */

public class ListenerImplementationclass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----Exection started-----"+methodName);
		
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----Exection pass-----"+methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----Exection fail-----"+methodName);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----Exection Skip-----"+methodName);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// Start of <suite> -@Before suite 
		System.out.println("-----suite exection started-----");
		
	}

	public void onFinish(ITestContext context) {
		// End of </site> -After suite 
		System.out.println("-----suite exection ended-----");
		
	}
	

}
