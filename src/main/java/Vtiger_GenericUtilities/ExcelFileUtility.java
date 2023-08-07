package Vtiger_GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class consists of generic methods related to the excel File 
 * @author dphan
 *
 */
public class ExcelFileUtility {
	/**
	 *  This method will read the data from excel sheet based on sheetname ,rownum, celnum given by the caller 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return value 
	 * @throws Throwable
	 */
	public String getDatafromexcel(String sheetName, int rowNum, int celNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return value;
	}
	/**
	 * This method wil write date into the excelsheet 
	 * @param sheetname
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void writedateformexcel(String sheetname,int rowNum,int celNum,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetname);//parameter
		Row ro = sh.createRow(rowNum);
		Cell cel = ro.createCell(celNum);
		cel.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(IConstants.excelfilePath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method read all the data inside sheet and use in data provider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IConstants.excelfilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();//capture numbers of rows 
		int lastCell = sh.getRow(0).getLastCellNum();//cpature numbers of cell
		
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
