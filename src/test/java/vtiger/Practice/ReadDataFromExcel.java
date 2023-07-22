package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Open the file in Java Readable format
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook Factory
		Workbook wb = WorkbookFactory.create(fise);
		
		//Step 3: get control of sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: get control of row
		Row rw = sh.getRow(1);
		
		//Step 5: get control of cell
		Cell ce = rw.getCell(2);
		Cell c=rw.getCell(1);
		
		//Step 6: capture the information inside the cell
		String value = ce.getStringCellValue();
		String value1 = c.getStringCellValue();
		System.out.println(value);
		System.out.println(value1);
		
		
		
	}

}
