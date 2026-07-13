package pageObject;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage {
    
    //Locator
    private Locator txtEmailAddress;
	private Locator txtPassword;
	private Locator btnLogin;

    //constructor
    public LoginPage(Page page)
    {
        super(page);
        txtEmailAddress=page.getByLabel("E-Mail Address");
		txtPassword=page.getByLabel("Password");
		btnLogin=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    }

    //methods/actions
    public void setEmailAddress(String email)
	{
		txtEmailAddress.fill(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.fill(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
