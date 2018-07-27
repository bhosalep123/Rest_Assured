package Rest_Utitls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sh1;
	public ExcelDataConfig(String excelPath)
	{
		try {
			File excel = new File(excelPath);
			FileInputStream fis = new FileInputStream(excel);
			 wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public String getData(String sheetname,int row,int column)
	{
		sh1 = wb.getSheet(sheetname);
		String data= sh1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}

}
