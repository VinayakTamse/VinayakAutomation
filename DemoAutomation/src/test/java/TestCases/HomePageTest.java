package TestCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	
	public HomePageTest()	{
		super();
	}
	
	@BeforeMethod
	public void setUp()	{
		Initialisation();
		homepage = new HomePage();
		throw new SkipException("Test Skipped");
		
	}
	
	@Test(priority=1, enabled=false)
	public void RegisterationTest()	{
		homepage.clickOnSigin();
		if (homepage.isElementPresent()==true)	{
			Assert.assertTrue(true);
			System.out.println("Element displayed");
		}
		else	{
			Assert.assertTrue(false);
		}
		
	}
	
	@AfterMethod
	public void end()	{
		driver.close();
	}
	
	

}
