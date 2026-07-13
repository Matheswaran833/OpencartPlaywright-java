package pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AccountRegistrationPage extends BasePage{
    
    //Locator
    private Locator txtFirstname;
	private Locator txtLastname;
	private Locator txtEmail;
	private Locator txtTelephone;
	private Locator txtPassword;
	private Locator txtConfirmPassword;
	private Locator chkPolicy;
	private Locator btnContinue;
	private Locator msgconfirmation;

    //constructor
    public AccountRegistrationPage(Page page)
    {
        super(page);
        txtFirstname=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"));
		txtLastname=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name"));
		txtEmail=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-mail"));
	    txtTelephone=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Telephone"));
		txtPassword=page.locator("#input-password");
		txtConfirmPassword=page.locator("#input-confirm");
		chkPolicy=page.locator("[name='agree']");
		btnContinue=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue"));
		msgconfirmation=page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Your Account Has Been Created!"));
    }

    //methods
	public void setFirstName(String fname)
	{
		txtFirstname.fill(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.fill(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.fill(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.fill(tel);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.fill(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txtConfirmPassword.fill(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkPolicy.check();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationmsg()
	{
		try {
			return msgconfirmation.textContent();
			
		    } 
		   catch (Exception e) 
		    {
			return e.getMessage();
		    }
	}
	

}
