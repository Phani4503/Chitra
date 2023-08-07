package Organization;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Oganization_with_DropDown {
public static void main(String[] args) {
	WebDriver driver= null;
	
	Random Rm = new Random();
	int ranNum = Rm.nextInt(10000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Load the url 
	driver.get("http://localhost:8888/");
	//Login to the Application 
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	//Create the Oganization
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	//Click on Plus symbole 
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//pass the values 
	String orgname = "Testyantra"+ranNum;
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	//Click on the DropDown
	WebElement Industrydropdown = driver.findElement(By.name("industry"));
	//Click on Chemicales
	Select se = new Select(Industrydropdown);
	se.selectByValue("Chemicals");
	//Click on save 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Validate
	String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains(orgname))
	{
		System.out.println("pass");
		System.out.println(OrgHeader);
	}
	else
	{
		System.out.println("Fail");
	}
	//Logout Application
	WebElement Adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(Adminimg).perform();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	driver.quit();
	System.out.println("Logout done");
	
}
}
