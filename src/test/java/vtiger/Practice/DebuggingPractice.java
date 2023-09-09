package vtiger.Practice;

import org.testng.annotations.Test;

public class DebuggingPractice {

	@Test
	public void test()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		int c=divide(5,5);
		System.out.println(c);
	}
	
	public static int divide(int a, int b)
	{
		int c = a/b;
		return c;
	}
}
