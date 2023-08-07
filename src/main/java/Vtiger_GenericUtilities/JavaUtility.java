package Vtiger_GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of all generic method releted to java 
 * @author dphan
 *
 */

public class JavaUtility {
	/**
	 * This method will generate the random numbers for every exection 
	 * @return 
	 */
	public int getRandomNumber()
	{
		Random r= new Random();
		int ran = r.nextInt(1000);
		return ran;
		
	}
	/**
	 * This method will generate the system date 
	 * @return
	 */
	public String getSystemDate()
	{
		Date d= new Date();
		String data = d.toString();
		return data;
	}
	/**
	 * This method will generate system date in specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d= new Date();
		String[] date = d.toString().split("");
		String currentdate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":","-");
		String dateInFormat = currentdate+"_"+month+"_"+year+"_"+time;
		
		return dateInFormat;
		
	}
	
	

}
