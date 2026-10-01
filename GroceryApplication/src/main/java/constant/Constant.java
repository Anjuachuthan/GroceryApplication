package constant;

public class Constant {
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	
	public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR="User is able to login with invalid credentials";
	public static final String VALIDUSERNAMEINVALIDPASSWORDERROR="User is able to login with valid Usernameand and invalid Password";
	public static final String INVALIDUSERNAMEVALIDPASSWORDERROR="User is able to login with invalid Usernameand and valid Password";
	
	public static final String UNABLETOLOGGEDOUTERROR="User is unable to logged out";
	public static final String UNABLETOADDNEWUSER="Unable to add new user";
	public static final String USERNOTFOUNDERROR="Searched user not found";
	
	public static final String UNABLETOADDDELIVERYBOYDETAILS="Unable to add Deliveryboy details";
	
	public static final String UNABLETOADDNEWCATEGORY ="Unable to add new category";
	public static final String ITEMNOTFOUNDERROR="Searched item not found";
	
}
