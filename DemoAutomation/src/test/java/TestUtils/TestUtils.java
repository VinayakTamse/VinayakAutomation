package TestUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class TestUtils extends TestBase {
	
	public static long pageLoadTime = 30;
	public static long impliciteWait = 50;
	public static WebDriverWait wait;
	
	public static  void setTimer(WebElement ele)	{
		wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	

}
