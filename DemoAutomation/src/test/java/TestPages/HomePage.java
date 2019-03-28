package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import TestUtils.TestUtils;

import TestBase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(how = How.XPATH, using="//a[@class='login']") WebElement login;
	@FindBy(xpath="//button[@type='submit']//child::span//i[@class='icon-user left']") WebElement createAcc;
	
	public HomePage()	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginRegisterPage clickOnSigin()	{
		login.click();
		return new LoginRegisterPage();
	}
	
	public boolean isElementPresent()	{
		TestUtils.setTimer(createAcc);
		return createAcc.isDisplayed();
	}
	
	

}
