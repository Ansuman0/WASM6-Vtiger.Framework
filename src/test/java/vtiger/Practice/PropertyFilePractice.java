package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Open the file in Java Readable format
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create Object Of Properties class from java.util 
		Properties pObj = new Properties();
		
		//Step 3: Load the file into properties
		pObj.load(fisp);
		
		//Step 4: give the key and read the value
		String value = pObj.getProperty("browser");
		System.out.println(value);
		
		String value1 = pObj.getProperty("url");
		System.out.println(value1);
		
		
	}

}
