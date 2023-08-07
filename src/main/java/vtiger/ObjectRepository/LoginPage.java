package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//create a seperate pom class for every web page 
	
	//Identify the web elements using @FindBY, @FindBys,@FindAll
	
	@FindBy(name ="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name ="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement LoginBtn;
	
	//Create a contructor to initialise the web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Provide getters to access the web elements

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		LoginBtn.click();
		
	}

}
