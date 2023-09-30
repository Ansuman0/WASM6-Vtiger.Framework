package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Step 1: Open the file in Java Readable format
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");

		// Step 2: Create a workbook Factory
		Workbook wb = WorkbookFactory.create(fise);

		// Step 3: get control of sheet
		Sheet sh = wb.getSheet("Organization");

		// Step 4: get control of row
		Row rw = sh.createRow(6);

		// Step 5: get control of cell
		Cell ce = rw.createCell(7);
		
		//Step 6: set the cell value
		ce.setCellValue("Chaitra");
		
		//Step 7: open the file in java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 8: Write the data into the file
		wb.write(fos);
		System.out.println("data written");
		wb.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
