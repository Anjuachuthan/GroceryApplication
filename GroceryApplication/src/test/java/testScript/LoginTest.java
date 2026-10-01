package testScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;
	@Test (priority=1,description="User is trying to login with valid credentials",groups= {"smoke"})
	public void verifyUserLoginwithValidcredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue);//Chaining of pages
		home=lp.clickSignInButton();	
		boolean dashBoardvalue=lp.verifyWhetherDashboardisDisplayed();//assertion
		Assert.assertTrue(dashBoardvalue,Constant.VALIDCREDENTIALERROR);
	}
	@Test (priority=2,description="User is trying to login with invalid credentials",retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginwithInvalidcredential() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue).clickSignInButton();	
		String actual=lp.verifyLoginPageTextisDisplayed();//assertion assertEquals()
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);	
	}
	@Test (priority=3,description="User is trying to login with valid username and invalid password")
	public void verifyUserLoginwithValidUsernameandInvalidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(2, 0, "Loginpage");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue).clickSignInButton();	
		String actual=lp.verifyLoginPageTextisDisplayed();//assertion
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.VALIDUSERNAMEINVALIDPASSWORDERROR);
		
		
	}
	@Test (priority=4,description="User is trying to login with invalid username and valid password",groups= {"smoke"},dataProvider="LoginData")
	public void verifyUserLoginwithInvalidUsernameandValidPassword(String usernamevalue,String passwordvalue) throws IOException
	{
		//String usernamevalue=ExcelUtility.getStringData(3, 0, "Loginpage");
		//String passwordvalue=ExcelUtility.getStringData(3, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue).clickSignInButton();	
		String actual=lp.verifyLoginPageTextisDisplayed();//assertion 
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDUSERNAMEVALIDPASSWORDERROR);
	}
	@DataProvider(name="LoginData")
	public Object[][] getDataFromDataProvider()
	{
		return new Object[][]
				{
			new Object[] {"admin","admin22"},new Object[] {"admin123","admin123"}
			
				};
	}
}
