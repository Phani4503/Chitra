package vtiger.Organizationtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger_GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrgnizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrgnizationinfoPage;
import vtiger.ObjectRepository.OrgnizationsPage;

public class CreateOrganizationWithIndustryTest extends BaseClass {

	@Test
	public void CreateOrgWithIndustryTest() throws Throwable

	{

		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eutil.getDatafromexcel("Organizations", 4, 2) + jutil.getRandomNumber();
		String IDUSTRY = eutil.getDatafromexcel("Organizations", 4, 3);

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
}
