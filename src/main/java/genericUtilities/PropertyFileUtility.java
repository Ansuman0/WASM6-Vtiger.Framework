package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Ansuman
 *
 */
public class PropertyFileUtility {

	/**
	 * This method will read data from property file and return value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPrpertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
	
}
