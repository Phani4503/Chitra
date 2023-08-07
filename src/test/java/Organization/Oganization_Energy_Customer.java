package Organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Oganization_Energy_Customer {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new EdgeDriver();
	//random numbera
	Random rm = new Random();
	int rannum = rm.nextInt(100);
	//Step 1: Read all the necessary data
	
			/* Read data from property File - Common Data */
			FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonDta.properties");
			Properties pObj = new Properties();
			pObj.load(fisp);
			String BROWSER = pObj.getProperty("browser");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("username");
			String PASSWORD = pObj.getProperty("password");
			
			/* Read Data from Excel sheet - Test data */
			FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fise);
			Sheet sh = wb.getSheet("Organizations");
			String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+rannum;
			String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
			String TYPE = sh.getRow(7).getCell(4).getStringCellValue();
			
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
				System.out.println("invalid Browser name");
			}
			
			
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Load the Url
	driver.get(URL);
	//Login to the application 
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	//Navigate to Organizations link
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	//Click on Create Organization look Up Image
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//Create Organization with Mandatory fields
	String orgname = ORGNAME+rannum;
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	//Click on Dropdown Industry
	WebElement DropdownIndustry = driver.findElement(By.name("industry"));
	//In DropDown Click on Energy
	Select sc = new Select(DropdownIndustry);
	sc.selectByValue(INDUSTRY);
	//Click on Type Drop down
	WebElement DropdownType = driver.findElement(By.name("accounttype"));
	//In Dropdown Click on Customer
	Select sctype = new Select(DropdownType);
	sctype.selectByValue(TYPE);
	//Click on save 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Verify
	String orgheder = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(orgheder.contains(orgname))
	{
		System.out.println("Pass");
		System.out.println(orgheder);
    }
	else
	{
		System.out.println("Fail");
	}
	//Logout Application
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	driver.quit();
	
	
	
}
}
