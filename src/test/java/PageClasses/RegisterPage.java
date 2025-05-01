package PageClasses;

public class RegisterPage {
	
	public static String addPatientButton()
	{
		String addPatientButton="//button[@name='AddPatientIcon']";
		return addPatientButton;
		
	}
	
	public static String patientIdentityButton()
	{
		String patientIdentityButton="(//button[@type='button' and @aria-selected='true'])[1]";
		return patientIdentityButton;
		
	}
	
	public static String firstName()
	{
		String fname="//input[@id='givenName']";
		return fname;
		
	}
	
	public static String lastName()
	{
		String lname="//input[@id='familyName']";
		return lname;
		
	}
	
	public static String gender()
	{
		String gender="(//span[@class='cds--radio-button__appearance'])[1]";
		return gender;
		
	}
	
	public static String age()
	{
		String age="//input[@id='yearsEstimated']";
		return age;
		
	}
	
	public static String dobStataus()
	{
		String dobSt="(//button[@aria-selected='false'])[2]";
		return dobSt;
	}
	
	
	
	public static String address()
	{
		String address="//input[@role='searchbox']";
		return address;
		
	}
	
	
	public static String btnregPat()
	{
		String btnregPat="//button[@type='submit']";
		return btnregPat;
		
	}

	public static String validatePatID()
	{
		String valId="//*[text()='OpenMRS ID']";
		return valId;
		
	}
	
	public static String closePg()
	{
		String cPg="//button[@aria-label='Close']";
		return cPg;
		
	}
	
	
	
	
	
	
	
	
	

}
