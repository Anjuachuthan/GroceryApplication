package testScript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
	HomePage hp;
	CategoryPage cp;
	@Test
	public void verifyWhetherUserisabledtoAddCategory() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");//Login 
		String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue);
		hp=lp.clickSignInButton();	
		
		cp=hp.categoryMoreInfo();
		cp.newButtonClick().categoryName().selectGroups();
		JavascriptExecutor js = (JavascriptExecutor)driver;//Window scroll
		js.executeScript("window.scrollBy(0,1000)","");
		cp.imageUpload().saveButtonClick();	
		boolean alertText=cp.verifyWhetherAlertisDisplayed();//Add assertion
		Assert.assertTrue(alertText,Constant.UNABLETOADDNEWCATEGORY);
    }
	@Test
	public void verifyWhetherUserisabledtoSearchtheNewlyaddedCategory() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");//Login
		String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue);
		hp=lp.clickSignInButton();
		
		cp=hp.categoryMoreInfo();
		cp.searchButtonClick().categoryItem().searchClick();
		cp.verifyListCategories();
		String actualdata=cp.verifyListCategories();//Assertion 
		String expecteddata="Tomato";
		Assert.assertEquals(actualdata, expecteddata,Constant.ITEMNOTFOUNDERROR);	
	}
}