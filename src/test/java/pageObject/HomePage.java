package pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage{

     //Locator
    private Locator lnkMyAccount;
    private Locator lnkRegister;
    private Locator lnkLogin;
    //constructor
    public HomePage(Page page)
    {
         super(page);
         lnkMyAccount=page.getByTitle("My Account");
	     lnkRegister=page.getByText("Register");
	     lnkLogin=page.getByText("Login");
    }
    
    //methods
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
   

    

    
}
