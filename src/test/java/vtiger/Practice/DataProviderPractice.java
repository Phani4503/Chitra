package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "getData")
	public void addToCartTest(String name ,int price ,String model)
	{
		System.out.println("Phone name is "+name+" price is "+price+" model name is "+model+"");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][3];
		
		data[0][0] = "Iphone";
		data[0][1] = 20000;
		data[0][2] = "ultra";
		
		data[1][0] = "nothing";
		data[1][1] = 2000;
		data[1][2] = "one";
		
		data[2][0] = "mi";
		data[2][1] = 1000;
		data[2][2] = "note 10";
		
		return data;
		
	}

}
