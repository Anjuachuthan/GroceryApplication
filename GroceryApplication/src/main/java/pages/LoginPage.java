package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	WaitUtility wu=new WaitUtility();
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement pwd;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signIn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashBoard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement loginPageText;

	public LoginPage enterUsernameOnUsernamefield(String username)
	{
		uname.sendKeys(username);
		return this;
	}
	public LoginPage enterPasswordOnPasswordfield(String password)
	{
		pwd.sendKeys(password);
		return this;
	}
	public HomePage clickSignInButton()
	{
		wu.waitUntilElementToBeClickable(driver, signIn);
		signIn.click();	
		return new HomePage(driver);
	}
	public boolean verifyWhetherDashboardisDisplayed()
	{
		return dashBoard.isDisplayed();
	}
	public String verifyLoginPageTextisDisplayed()
	{
		return loginPageText.getText();
	}
}
