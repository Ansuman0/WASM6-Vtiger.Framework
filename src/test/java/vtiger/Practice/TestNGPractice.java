package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void create()
	{
		Assert.fail();
		System.out.println("create");
	}
	
	@Test(dependsOnMethods = "create")
	public void modify()
	{
		Assert.fail();
		System.out.println("modify");
	}
	
	@Test(dependsOnMethods = {"create","modify"})
	public void delete()
	{
		System.out.println("delete");
	}

}
