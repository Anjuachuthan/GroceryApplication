package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	PageUtility pu=new PageUtility();
	
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(xpath="//input[@id='username']") WebElement newusername;
	@FindBy(xpath="//input[@id='password']") WebElement newpassword;
	@FindBy(xpath="//select[@id='user_type']") WebElement userType;
	@FindBy(xpath="//i[@class='fa fa-save']") WebElement saveButton ;
	@FindBy(xpath="//button[@class='close']") WebElement newusersavedAlert;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;
	@FindBy(xpath="//input[@id='un']") WebElement savedUsername;
	@FindBy(xpath="//select[@id='ut']") WebElement selectUserType;
	@FindBy(xpath="//button[@value='sr']") WebElement searchSavedUser;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement usersTable;
	
	public AdminUsersPage newButtonClick()
	{
		newButton.click();
		return this;
	}
	public AdminUsersPage enterNewUsernameOnUsernamefield(String username)
	{
		newusername.sendKeys(username);
		return this;
	}
	public AdminUsersPage enterNewPasswordOnPasswordfield(String password)
	{
		newpassword.sendKeys(password);
		return this;
	}
	public AdminUsersPage selectUserType()
	{
		pu.selectDropdownWithVisibleText(userType, "Admin");
		return this;
	}
	public AdminUsersPage saveButtonClick()
	{
		saveButton.click();
		return this;
	}
	public AdminUsersPage searchButtonClick()
	{
		searchButton.click();
		return this;
	}
	public AdminUsersPage enterSavedUsername(String username)
	{
		savedUsername.sendKeys(username);
		return this;
	}
	public AdminUsersPage selectSavedUserType()
	{
		pu.selectDropdownWithVisibleText(selectUserType, "Admin");
		return this;
	}
	public AdminUsersPage searchSavedUserButtonClick()
	{
		searchSavedUser.click();
		return this;
	}
	public boolean verifyWhetherAlertisDisplayed()
	{
		return newusersavedAlert.isDisplayed();	
	}	
	public String verifyAdminuserUsername()
	{
		return usersTable.getText();	
	}
}
