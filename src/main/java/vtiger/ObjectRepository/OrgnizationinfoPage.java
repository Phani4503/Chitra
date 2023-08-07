package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationinfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	
	
	public OrgnizationinfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}


	
	
	//business logic 
	/**
	 * mmthis method will capture the headertext and return caller
	 * @return
	 */
	
	public String getHeaderText()
	{
		return orgHeaderText.getText();
	}

}
