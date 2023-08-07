package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationsPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookImg;
	
	public OrgnizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateOrgLookImg() {
		return createOrgLookImg;
	}
	//Business logic 
	public void clickonCreateOrgLookImg()
	{
		createOrgLookImg.click();
	}

}
