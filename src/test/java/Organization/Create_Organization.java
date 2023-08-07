package Organization;

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
import vtiger.ObjectRepository.OrgnizationinfoPage;
import vtiger.ObjectRepository.OrgnizationsPage;

public class Create_Organization {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = null;
		// create object of required utilities
		JavaUtility jutil = new JavaUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		// Step 1: Read all the necessary data

		// Read data from property File - Common Data
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String URL = putil.getDataFromPropertyFile("url");
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eutil.getDatafromexcel("Organizations", 4, 2) + jutil.getRandomNumber();
		// String IDUSTRY = eutil.getDatafromexcel("Organizations", 4, 3);

		// Step 2: Launch the browser - driver is acting based runtime data - RunTime
		// polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " --- Browser launched----");

		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " --- Browser launched----");
		} else {
			System.out.println("Browser name");
		}
		wutil.Maximizewindow(driver);
		wutil.waitforelementtoload(driver);
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.clickonorgLink();

		OrgnizationsPage op = new OrgnizationsPage(driver);
		op.clickonCreateOrgLookImg();

		CreateNewOrgnizationPage cop = new CreateNewOrgnizationPage(driver);
		cop.createOrgnization(ORGNAME);

		// Step 8: Validate
		OrgnizationinfoPage oip = new OrgnizationinfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("PASS");
			System.out.println(OrgHeader);
		} else {
			System.out.println("Fail");
		}

		hp.logoutOfApp(driver);

		System.out.println("======Logout successfull======");

		driver.quit();

	}
}
