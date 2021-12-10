package elements;

public class Loginpage_Ele {
//	public static String Login_page ="//*[text()='Welcome, Please Sign In!']";
	public static String Login_page = "//div/h1";
	public static String username_id = "Username";
	public static String pwd_name = "Password";
	public static String Login_Btn = "//*[@type='submit']";
//	public static String Logout = "//*[text()='Log out']";
	public static String Login_Screen = "//*[@title='nopCommerce']";
//	public static String Login_Error_Msg ="//div[@class='message-error validation-summary-errors']";
	public static String Login_Error_Msg = "//div[text()='Login was unsuccessful. Please correct the errors and try again.']";
//	public static String Remeber_Label="//label[@class='custom-control-label']";
	public static String Remeber_Label = "RememberMe";
	public static String Forget_Un_Pwd = "//span[@class='forgot-password']";
	public static String Recovey_Page = "//h1[text()='Username and password recovery']";
	public static String Email_id = "Email";
	public static String Recover_Btn = "send-email";
	public static String Recover_Msg = "//div[@class='result']";

}
