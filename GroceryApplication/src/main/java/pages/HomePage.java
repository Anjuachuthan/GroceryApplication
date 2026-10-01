package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='img-circle']") WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminUsersMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']") WebElement manageDeliveryBoyMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']") WebElement categoryMoreInfo;
		
	public HomePage adminClick()
	{
		admin.click();
		return this;
	}
	public LoginPage logoutClick()
	{
		logout.click();
		return new LoginPage(driver);
	}
	public AdminUsersPage adminUsersMoreInfoClickbutton()
	{
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}
	public ManageDeliveryBoyPage manageDeliveryBoyMoreInfobutton()
	{
		manageDeliveryBoyMoreInfo.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public CategoryPage categoryMoreInfo()
	{
		categoryMoreInfo.click();
		return  new CategoryPage(driver);
	}
}
