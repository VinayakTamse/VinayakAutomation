package TestBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import TestUtils.TestUtils;

public class TestBase {
	
	public static FileInputStream file;
	public static Properties prop;
	
	public static TestBase base = new TestBase();
	public static WebDriver driver;
	
	public TestBase()	{
		try	{
		file = new FileInputStream("C:\\Users\\DELL\\workspace\\DemoAutomation\\src\\test\\java\\Configuration\\cofig.properties");
		prop = new Properties();
		prop.load(file);
		}
		catch(Exception e)	{
			System.out.println(e);
		}
	}
	
	public String getBrowser()	{
		String browser = prop.getProperty("Browser");
		return browser;
	}
	
	public String getChromePath()	{
		String chromepath = prop.getProperty("Chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath()	{
		String firefoxpath = prop.getProperty("Firefoxpath");
		return firefoxpath;
	}
	
	public String getUrl()	{
		String url = prop.getProperty("url");
		return url;
	}
	
	public String getXlFile()	{
		String xlfile = prop.getProperty("ExcelFile");
		return xlfile;
	}
	
	public static void Initialisation()	{
		if (base.getBrowser().equals("Chrome"))	{
			System.setProperty("webdriver.chrome.driver", base.getChromePath());
			driver = new ChromeDriver();
		}
		
		else if (base.getBrowser().equals("Firefox"))	{
			System.setProperty("webdriver.gecko.driver", base.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(base.getUrl());
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageLoadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.impliciteWait, TimeUnit.SECONDS);
	}

}
