package testScript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage hp;
	ManageDeliveryBoyPage mdp;
	@Test
	public void verifyWhetherUserisabledtoAddNewDeliveryBoy() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(0, 0, "Loginpage");//Login 
		String passwordvalue=ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage lp=new LoginPage(driver);
		lp.enterUsernameOnUsernamefield(usernamevalue).enterPasswordOnPasswordfield(passwordvalue);
		hp=lp.clickSignInButton();	
		
		mdp=hp.manageDeliveryBoyMoreInfobutton();
		mdp.newButtonClick();
		RandomDataUtility rdu=new RandomDataUtility();
		String newDeliveryboyNamevalue=rdu.generateRandomUsername();
		String newEmailvalue=rdu.generateRandomEmailID();
		String newPhonenumbervalue=rdu.generateRandomPhoneNumber();
		String newAddressvalue=rdu.generateRandomAddress();
		String newUsername=rdu.generateRandomUsername();
		String newPassword=rdu.generateRandomPassword();		
		mdp.enterNameofDeliveryboy(newDeliveryboyNamevalue).enterEmailID(newEmailvalue).enterPhoneNumber(newPhonenumbervalue).enterAddress(newAddressvalue).enterUsername(newUsername).enterpassword(newPassword);
		JavascriptExecutor js = (JavascriptExecutor)driver;//Window scroll
		js.executeScript("window.scrollBy(0,500)","");
		mdp.saveButtonClick();	
		boolean alertText=mdp.verifyWhetherAlertisDisplayed();//Add assertion
		Assert.assertTrue(alertText,Constant.UNABLETOADDDELIVERYBOYDETAILS);
	}
}
