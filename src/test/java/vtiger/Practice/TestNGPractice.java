package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount = 5)
	public void createCustomer()
	{
		Assert.fail();
		System.out.println("customer created");
	}
	
	@Test(enabled = false)
	public void modifyCustomer()
	{
		
		System.out.println("customer modify");
	}
	
	@Test
	public void deleteCustomer()
	{
		System.out.println("customer delete");
	}

}
