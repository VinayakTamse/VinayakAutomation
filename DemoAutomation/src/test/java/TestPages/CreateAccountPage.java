package TestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.TestBase;

public class CreateAccountPage extends TestBase {
	
	
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement Password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement selectDay;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement selectMonth;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement selectYear;
	
	@FindBy(xpath="//input[@name='company']")
	WebElement selectCompany;
	
	@FindBy(css="input#address1")
	WebElement enterAddress;
	
	@FindBy(css="input[name=city]")
	WebElement enterCity;
	
	@FindBy(css="select[id=id_state]")
	WebElement selectState;
	
	
	
	public CreateAccountPage()	{
		PageFactory.initElements(driver, this);
	}
	
	public void createAccount(String Gender, String Fname, String Lname, String pass, String Day, String Month, String Year, String Company, String address, String city, String text){
		
		driver.findElement(By.xpath("//input[@id='"+Gender+"']")).click();
		Firstname.sendKeys(Fname);
		lastname.sendKeys(Lname);
		Password.sendKeys(pass);
		Select sel = new Select(selectDay);
		sel.selectByValue(Day);
		Select sel2 = new Select(selectMonth);
		sel2.selectByValue(Month);
		Select sel3 = new Select(selectYear);
		sel3.selectByValue(Year);
		selectCompany.sendKeys(Company);
		enterAddress.sendKeys(address);
		enterCity.sendKeys(city);
		Select sel4 = new Select(selectState);
		sel4.selectByVisibleText(text);
	}

}
