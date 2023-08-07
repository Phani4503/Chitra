package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger_GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	@FindBy(linkText = "Organizations")
	private WebElement OrginationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorImg;
	
	@FindBy(linkText  = "Sign Out")
	private WebElement SignoutLnk;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrginationLnk() {
		return OrginationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}

	public WebElement getSignoutLnk() {
		return SignoutLnk;
	}
	
	//Business library
	public void clickonorgLink()
	{
		OrginationLnk.click();
	}
	public void clickonContactLink()
	{
		ContactsLnk.click();
	}
	/**
	 * This method logout of the application
	 * @param driver
	 * @throws Throwable
	 */
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver, AdminstratorImg);
		Thread.sleep(2000);
		SignoutLnk.click();
	}
	
	

}
