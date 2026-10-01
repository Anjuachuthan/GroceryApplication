package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage hp;
	@Test
	public void verifyWhetherUserisAbletoSuccessfullyLoggedOut() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue);
		hp=lp.clickSignInButton();	
		
		hp.adminClick();
		lp=hp.logoutClick();
		String actual=lp.verifyLoginPageTextisDisplayed();//assertion
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.UNABLETOLOGGEDOUTERROR);
	}
}
