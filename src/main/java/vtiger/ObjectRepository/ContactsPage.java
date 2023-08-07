package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(linkText = "Contacts")
	private WebElement ContactHeaderText;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	//Business logic
	/**
	 * This method is click on the Contact lookup img 
	 */
	
	public void clickonCreateContactsLookImg()
	{
		ContactHeaderText.click();
	}

}
