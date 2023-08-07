package vtiger.Organizationtests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger_GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrgnizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgnizationinfoPage;
import vtiger.ObjectRepository.OrgnizationsPage;

@Listeners(Vtiger_GenericUtilities.ListenerImplementationclass.class)

public class Oganization_Energy_CustomerTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void Org_eng_CusterTest() throws Throwable {

		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eutil.getDatafromexcel("Organizations", 4, 2) + jutil.getRandomNumber();
		String IDUSTRY = eutil.getDatafromexcel("Organizations", 4, 3);
		String TYPE = eutil.getDatafromexcel("Organizations", 7, 4);

		// Step 2: Launch the browser - driver is acting based runtime data - RunTime

		// Navigate to Organizations link

		HomePage hp = new HomePage(driver);
		hp.clickonorgLink();

		OrgnizationsPage op = new OrgnizationsPage(driver);
		op.clickonCreateOrgLookImg();

		CreateNewOrgnizationPage cop = new CreateNewOrgnizationPage(driver);
		cop.createOrgnization(ORGNAME, IDUSTRY, TYPE);

		// Click on Dropdown Industry

		OrgnizationinfoPage oip = new OrgnizationinfoPage(driver);
		String orgheder = oip.getHeaderText();

		Assert.assertTrue(orgheder.contains(ORGNAME));

		System.out.println("Pass");
		System.out.println(orgheder);

	}
	@Test
	public void sampleTest()
	{
		System.out.println("Sample");
	}
	

}
