package Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Vtiger_GenericUtilities.ExcelFileUtility;
import Vtiger_GenericUtilities.JavaUtility;
import Vtiger_GenericUtilities.PropertyFileUtility;
import Vtiger_GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.CreateNewOrgnizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrgnizationsPage;

public class CreateOrgWithIndustryUsingDDT_GU {
	public static void main(String[] args) throws Throwable {
       WebDriver driver = null;

        //create object of required utilities
        JavaUtility jutil = new JavaUtility();
        ExcelFileUtility eutil= new ExcelFileUtility();
        PropertyFileUtility putil = new PropertyFileUtility();
        WebDriverUtility wutil = new WebDriverUtility();
        //Step 1: Read all the necessary data
		
		//Read data from property File - Common Data 
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String URL = putil.getDataFromPropertyFile("url");
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eutil.getDatafromexcel("Organizations", 4, 2)+jutil.getRandomNumber();
		String IDUSTRY = eutil.getDatafromexcel("Organizations", 4, 3);
		
		//Step 2: Launch the browser - driver is acting based runtime data - RunTime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" --- Browser launched----");
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" --- Browser launched----");
		}
		else
		{
			System.out.println("Browser name");
		}
		wutil.Maximizewindow(driver);
		wutil.waitforelementtoload(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 3: Load the URL
		driver.get(URL);
		
		//Step 4: Login to the Application
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 5: Click on Organizations Link
		//driver.findElement(By.linkText("Organizations")).click();
		
		HomePage hp =new HomePage(driver);
		hp.clickonorgLink();
		
		
		//Step 6: click on Create Organization look up image
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		OrgnizationsPage op = new OrgnizationsPage(driver);
		op.clickonCreateOrgLookImg();
		
		//Step 6: create Organization
		//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		CreateNewOrgnizationPage cop = new CreateNewOrgnizationPage(driver);
		cop.createOrgnization(ORGNAME,IDUSTRY);
		
		//Step 6: Choose 'Chemicals' in industry drop down
		//WebElement industryDropDown = driver.findElement(By.xpath("//select[@name='industry']"));
		//wutil.handleDropDown(industryDropDown, IDUSTRY);
		
		//Step 7: save 
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step 9: Logout of Application
		
		hp.logoutOfApp(driver);
		/*WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.mouseHoverAction(driver, AdminImg);
		
		driver.findElement(By.linkText("Sign Out")).click();*/
		
		System.out.println("Logout successfull");
		
}
}


