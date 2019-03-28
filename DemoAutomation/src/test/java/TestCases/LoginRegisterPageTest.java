package TestCases;


import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.HomePage;
import TestPages.LoginRegisterPage;
import Utilities.ReadExcelUtils;

public class LoginRegisterPageTest extends TestBase {
	
	HomePage homepage;
	LoginRegisterPage register;
	
	public LoginRegisterPageTest()	{
		super();
	}
	
	@BeforeMethod
	public void setUp()	{
		Initialisation();
		homepage = new HomePage();
		register = homepage.clickOnSigin();
		throw new SkipException("Test Skipped");
	}
	
	@Test(priority=1, dataProvider="sheetdata", enabled=false)
	public void EnterEmailTest(String email)	{
		register.enterEmail(email);
	}
	
	@DataProvider(name="sheetdata")
	public String[][] data() throws Exception	{
		String xlFile = base.getXlFile();
		String SheetName = "Sheet2";
		int row = ReadExcelUtils.getRowNo(xlFile, SheetName);
		int cell = ReadExcelUtils.getCellNo(xlFile, SheetName, 1);
		String [][] Data = new String[row][cell];
		for (int i=0; i<row; i++)	{
			for (int j=0; j<cell; j++)	{
				Data[i][j] = ReadExcelUtils.getCellData(xlFile, SheetName, i+1, j);
			}
		}
		
		return Data;
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.close();
	}

}
