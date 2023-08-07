package vtiger.Organizationtests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger_GenericUtilities.BaseClass;
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

@Listeners(Vtiger_GenericUtilities.ListenerImplementationclass.class)
public class CreateMultipleOrgWithIndustry extends BaseClass {

	@Test(dataProvider = "getData")
	public void createMultiOrg(String ORG, String IDUSTRY) throws Throwable {
		// Create orgnization

		/* Read Data from Excel sheet - Test data */
		String ORGNAME = ORG + jutil.getRandomNumber();

		// Step 2: Launch the browser - driver is acting based runtime data - RunTime

		// Step 4: Login to the Application

		// Step 5: Click on Organizations Link

		HomePage hp = new HomePage(driver);
		hp.clickonorgLink();

		// Step 6: click on Create Organization look up image

		OrgnizationsPage op = new OrgnizationsPage(driver);
		op.clickonCreateOrgLookImg();

		// Step 6: create Organization

		CreateNewOrgnizationPage cop = new CreateNewOrgnizationPage(driver);
		cop.createOrgnization(ORGNAME, IDUSTRY);

		OrgnizationinfoPage oip = new OrgnizationinfoPage(driver);
		String OrgHeader = oip.getHeaderText();

		Assert.assertTrue(OrgHeader.contains(ORGNAME));

		System.out.println("pass");
		System.out.println(OrgHeader);

	}

	@DataProvider
	public Object[][] getData() throws Throwable, IOException {
		return eutil.readMultipleData("MultipleOrg");
	}

}
