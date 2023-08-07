package Vtiger_GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consits of generic methods releted to proprty file 
 * @author dphan
 *
 */

public class PropertyFileUtility {
	/**
	 * This method read data form Property file based on given data 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IConstants.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
