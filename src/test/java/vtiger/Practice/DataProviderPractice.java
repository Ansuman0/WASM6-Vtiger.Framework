package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "phones")
	public void sampleDataTest(String name,String model, int qty)
	{
		System.out.println(name+"<->"+model+"<->"+qty);
	}
	
	@DataProvider(name = "phones")
	public Object[][] getData1()
	{                         // 4 different Data sets consisting of 3 details
		Object[][] data = new Object[4][3];
		
		data[0][0] = "Samsung";
		data[0][1] = "A80";
		data[0][2] = 10;
		
		data[1][0] = "Iphone";
		data[1][1] = "S14";
		data[1][2] = 20;
		
		data[2][0] = "Nokia";
		data[2][1] = "1100";
		data[2][2] = 15;
		
		data[3][0] = "Vivo";
		data[3][1] = "V24";
		data[3][2] = 30;
		
		return data;
	}
	
	

}
