package vtiger.Practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {

		PropertyFileUtility pUtil = new PropertyFileUtility();

		String value = pUtil.readDataFromPrpertyFile("username");
		System.out.println(value);

		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Organization", 1, 2);
		System.out.println(data);

//		eUtil.writeDataIntoExcel("Trial1", 3, 4, "SpiderMan");
//		System.out.println("Data added");

		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getRandomNumber());
		System.out.println(jUtil.getSystemDateInFormat());

	}

}
