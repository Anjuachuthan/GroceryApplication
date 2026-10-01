package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {
	HomePage hp;
	AdminUsersPage aup;
	@Test
	public void verifyWhetherUserisabledtoaddNewAdminUser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");//Login 
		String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue);
		hp=lp.clickSignInButton();	
		aup=hp.adminUsersMoreInfoClickbutton();
		aup.newButtonClick();
		
		RandomDataUtility rdu=new RandomDataUtility();
		String newUsernamevalue=rdu.generateRandomUsername();
		String newPasswordvalue=rdu.generateRandomPassword();
		aup.enterNewUsernameOnUsernamefield(newUsernamevalue).enterNewPasswordOnPasswordfield(newPasswordvalue).selectUserType().saveButtonClick();
		
		boolean alertText=aup.verifyWhetherAlertisDisplayed();//Add assertion
		Assert.assertTrue(alertText,Constant.UNABLETOADDNEWUSER);
	}
	
	@Test
	public void verifyWhetherUserisabledtoSearchtheNewlyaddedAdminuser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");//Login
		String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue);
		hp=lp.clickSignInButton();	
		aup=hp.adminUsersMoreInfoClickbutton();
		aup.searchButtonClick();
		String newUsernamevalue=ExcelUtility.getStringData(0, 0, "Adminuser");
		aup.enterSavedUsername(newUsernamevalue).selectSavedUserType().searchSavedUserButtonClick();
		
		String actualUsername=aup.verifyAdminuserUsername();//Assertion 
		String expectedUsername="anju";
		Assert.assertEquals(actualUsername, expectedUsername,Constant.USERNOTFOUNDERROR);
	}
}
