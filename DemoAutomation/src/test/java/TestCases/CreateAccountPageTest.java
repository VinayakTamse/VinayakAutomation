package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBase;
import TestPages.CreateAccountPage;
import TestPages.HomePage;
import TestPages.LoginRegisterPage;
import Utilities.ReadExcelUtils;

public class CreateAccountPageTest extends TestBase {
	
	HomePage homepage;
	LoginRegisterPage register;
	CreateAccountPage createAccount;

	
	public CreateAccountPageTest()	{
		super();
	}
	
	@BeforeMethod
	public void setUp()	{
		Initialisation();
		homepage = new HomePage();
		register = homepage.clickOnSigin();
		register = new LoginRegisterPage();
		createAccount = register.enterEmail("a.vinayaktamse@gmail.com");
		createAccount = new CreateAccountPage();
		
		
	}
	
	
	
	@Test(priority=1, dataProvider="excelSheet")
	public void createAccountTest(String Gender, String Fname, String Lname, String pass, String Day, String Month, String Year, String Company, String address, String city, String text)	{
		createAccount.createAccount(Gender, Fname, Lname, pass, Day, Month, Year, Company, address, city, text);
	}
	
	@DataProvider(name="excelSheet")
	public String[][] Data() throws Exception	{
		String xlfile= base.getXlFile();
		int row = ReadExcelUtils.getRowNo(xlfile, "Sheet1");
		int cell = ReadExcelUtils.getCellNo(xlfile, "Sheet1", 1);
		String [][] celldata = new String[row][cell];
		for (int i=0; i<row; i++)	{
			for (int j=0; j<cell; j++)	{
				celldata[i][j] = ReadExcelUtils.getCellData(xlfile, "Sheet1", i+1, j);
			}
		}
		
		return celldata;
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.close();
	}
	
	


}
