package TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;
import TestPages.HomePage;

public class LoginRegisterPage extends TestBase {
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement createEmail;
	
	@FindBy(xpath="//button[@type='submit']//child::span//i[@class='icon-user left']") WebElement createAcc;
	
	public LoginRegisterPage()	{
		PageFactory.initElements(driver, this);
	}
	
	public CreateAccountPage enterEmail(String email)	{
		createEmail.sendKeys(email);
		createAcc.click();
		return new CreateAccountPage();
		
	}

}
