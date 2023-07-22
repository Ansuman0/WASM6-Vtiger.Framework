package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsserrtionsPractice {
	
	@Test
	public void test()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(false, true);
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}

	@Test
	public void test1()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		
		System.out.println("Step 2");//mandatory
		
		 //pass
		
		System.out.println("Step 3");//non mandatory field
		
		sa.assertTrue(false); //fail
		
		System.out.println("Step 4");
		
		System.out.println("Step 5");//non mandatory field
		
		sa.assertTrue(false); //fail
		
		Assert.assertTrue(false);
		
		System.out.println("Step 6");
		
		sa.assertAll(); //log - softasserts
		
		 // log all the assertion failurre
	}
}
