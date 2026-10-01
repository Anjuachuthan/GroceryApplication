package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(xpath="//input[@id='name']") WebElement name;
	@FindBy(xpath="//input[@id='email']") WebElement email ;
	@FindBy(xpath="//input[@id='phone']") WebElement phoneNumberOfDeliveryboy ;
	@FindBy(xpath="//textarea[@id='address']") WebElement deliveryboyAddress;
	@FindBy(xpath="//input[@id='username']") WebElement deliveryboyUsername  ;
	@FindBy(xpath="//input[@id='password']") WebElement deliveryboyPassword ;
	@FindBy(xpath="//button[text()='Save']") WebElement saveButton ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	
	public ManageDeliveryBoyPage newButtonClick()
	{
		newButton.click();
		return this;
	}
	public ManageDeliveryBoyPage enterNameofDeliveryboy(String nameofDeliverboy)
	{
		name.sendKeys(nameofDeliverboy);
		return this;
	}
	public ManageDeliveryBoyPage enterEmailID(String emailId)
	{
		email.sendKeys(emailId);
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNumber(String phoneNumber)
	{
		phoneNumberOfDeliveryboy.sendKeys(phoneNumber);
		return this;
	}
	public ManageDeliveryBoyPage enterAddress(String address)
	{
		deliveryboyAddress.sendKeys(address);
		return this;
	}
	public ManageDeliveryBoyPage enterUsername(String userName)
	{
		deliveryboyUsername.sendKeys(userName);
		return this;
	}
	public ManageDeliveryBoyPage enterpassword(String password)
	{
		deliveryboyPassword.sendKeys(password);
		return this;
	}
	public ManageDeliveryBoyPage saveButtonClick()
	{
		saveButton.click();
		return this;
	}
	public boolean verifyWhetherAlertisDisplayed()
	{
		return alertMessage.isDisplayed();
	}	
}
