package Vtiger_GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all the re useble methods related to the web driver action 
 * @author dphan
 *
 */

public class WebDriverUtility {
	/**
	 * This method is maximize the window 
	 * @param driver
	 */
	public void Maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * this method is minimize the window 
	 * @param driver
	 */
	public void minimizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for all the findelement and findelements 
	 * @param driver
	 */
	public void waitforelementtoload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method wait until the specide element is visible i dom 
	 * @param driver
	 * @param elemet
	 */
	public void waitforelementTobevisible(WebDriver driver ,WebElement elemet)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elemet));
	}
	/**
	 * This method will handle dropdown using index 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	/**
	 * This method will handle dropdown using value 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle dropdown using text
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)//change the order 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * this method will perfrom mousehoveraction on target element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will double click anywhere one web page 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will double click on a web element 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)//over loading 
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perfrom right click anywhere on the web page 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
		
	}
	/**
	 * This method will perfrom right click on a partical web element 
	 * @param driver
	 * @param element
	 */
	public void rightCickAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method Will Perfrom draganddrop action 
	 * @param driver
	 * @param srcelement
	 * @param tragetElemet
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcelement,WebElement tragetElemet)
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(srcelement, tragetElemet).perform();
	}
	/**
	 * This method is used to move the cursor anywhere of the web page based on offset values
	 * @param driver
	 * @param xoffset
	 * @param yoffset
	 */
	public void moveAcrossWebPage(WebDriver driver,int xoffset, int yoffset)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xoffset, yoffset).click().perform();
	}
	/**
	 * This method will scroll vertically for 500 pixels 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method will scroll vertically until the element reference 
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	/**
	 * this method will accept the alert pop up 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	} 
	/**
	 * This method will cencel the confirmation pop up 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will enter the text in prompt pop up 
	 * @param driver
	 * @param text
	 */
	public void sendTextToAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method is capture the alert message nad return to the caller 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will handle frame based on value of name or id attribute 
	 * @param driver
	 * @param nameorid
	 */
	public void handleFrame(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	/**
	 * This method will handle frame based on web element 
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
		
	}
	/**
	 * This method to switch the control back to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will help to switch the controlback to the current page 
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will switch the selenium control from parent to child 
	 * or child to parent based on partial window titleśś
	 * @param driver
	 * @param partialwinTitle
	 */
	public void switchTOwindow(WebDriver driver,String partialwinTitle)
	{
		//step 1:captur all the window ids 
	     Set<String> allwindowIds = driver.getWindowHandles();
		
		//step 2:iterate through individual ids 
	     for(String winId:allwindowIds)
	     {
	    	//step 3:switch to each id and capture the title 
	    	 String currentTitle = driver.switchTo().window(winId).getTitle();
	    	 
	    	//step 4: compare the title with required refernce 
	    	 if(currentTitle.contains(partialwinTitle))
	    	 {
	    		 break;
	    	 }
	     }
		}
	/**
	 * this method will take screenshot and return the absolute path of it
	 * @param driver
	 * @param screenshotname
	 * @return path
	 * @throws Throwable
	 */
	public String takeScreenShot(WebDriver driver,String screenshotname) throws Throwable
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenshotname+".png");
		Files.copy(src, dst);//this class from commns IO tool
		return dst.getAbsolutePath();//	attach the screenshot to the Extence reports 
	}
	

}
