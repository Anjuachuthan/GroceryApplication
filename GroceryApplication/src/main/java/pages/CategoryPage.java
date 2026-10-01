package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(xpath="//input[@id='category']") WebElement categoryName;
	@FindBy(xpath="//li[@id='4-selectable']") WebElement selectGroups;
	@FindBy(xpath="//input[@name='main_img']") WebElement image;
	@FindBy(xpath="//button[text()='Save']") WebElement saveButton;
	@FindBy(xpath="//i[@class='icon fas fa-check']") WebElement alertMessage;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;
	@FindBy(xpath="//input[@class='form-control']") WebElement category;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") WebElement search;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement categoryList;
	
	public CategoryPage newButtonClick()
	{
		newButton.click();
		return this;
	}
	public CategoryPage categoryName()
	{
		categoryName.sendKeys("Tomato");
		return this;
	}
	public CategoryPage selectGroups()
	{
		selectGroups.click();
		return this;
	}
	public CategoryPage imageUpload()
	{
		image.sendKeys("C:\\Users\\AKHIL\\Pictures\\images.jpg");
		return this;
	}
	public CategoryPage saveButtonClick()
	{
		saveButton.click();
		return this;
	}
	public boolean verifyWhetherAlertisDisplayed()
	{
		return alertMessage.isDisplayed();
	}
	public CategoryPage searchButtonClick()
	{
		searchButton.click();
		return this;
	}
	public CategoryPage categoryItem()
	{
		category.sendKeys("Tomato");
		return this;
	}
	public CategoryPage searchClick()
	{
		search.click();
		return this;
	}
	public String verifyListCategories()
	{
		return categoryList.getText();	
	}
}
