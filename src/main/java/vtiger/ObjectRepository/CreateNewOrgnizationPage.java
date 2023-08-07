package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger_GenericUtilities.WebDriverUtility;

public class CreateNewOrgnizationPage extends WebDriverUtility{
	@FindBy(name = "accountname")
	private WebElement OrgnameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	
	public CreateNewOrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
     
	public WebElement getOrgnameEdt() {
		return OrgnameEdt;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getAccountnameEdt() {
		return OrgnameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business logic
	/**
	 * this method will create ognaztion with mandatry feild
	 * @param ORGNAME
	 */
	
	public void createOrgnization(String ORGNAME)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	/**
	 * this will create ognization with industry
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrgnization(String ORGNAME,String INDUSTRY)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropdown, INDUSTRY);
		saveBtn.click();
	}
	/**
	 * This method is used to save the OrgName,Industry,Type data 
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	
	public void createOrgnization(String ORGNAME,String INDUSTRY,String TYPE)
	{
		OrgnameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropdown, INDUSTRY);
		handleDropDown(typeDropdown, TYPE);
		saveBtn.click();
	}
	

}
