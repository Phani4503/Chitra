package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
	
	@Test
	public void read()
	{
		 String un = System.getProperty("username");
		 System.out.println(un);
		String PWD = System.getProperty("password");
		System.out.println(PWD);
	}

}
