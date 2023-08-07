package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractices {
	
	@Test
	public void sampleclass()
	{
		SoftAssert sa = new SoftAssert();
		int a=4;//exp
		int b=4;//actual 
		sa.assertEquals(a, b);
		System.out.println("Exection and validation is completed");
	}

}
