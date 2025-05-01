package PageClasses;

public class LoginPage {
	
	public  String getUserName()
	{
		String uname="//input[@id='username']";
		return uname;
	}
	
	public  String getContinueButton()
	{
		String btn_continue="//button[.='Continue']";
		return btn_continue;
	}
	
	public  String getPassword()
	{
		String password="//input[@id='password']";
		return password;
	}
	
	public  String clickOnSubmit()
	{
		String btn_Submit="//button[@type='submit']";
		return btn_Submit;
	}
	
	public String verifyLogin() {
		String verifyText = "//p[text()='Home']";
		return verifyText;
	}
	
	

}
