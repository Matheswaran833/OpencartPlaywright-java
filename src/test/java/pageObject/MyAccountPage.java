package pageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyAccountPage extends BasePage{
    
    //Locator
    private Locator msgHeading;
	private Locator lnkLogout;

    //constructor
    public MyAccountPage(Page page)
    {
        super(page);
        msgHeading=page.locator("//h2[text()='My Account']");
		lnkLogout=page.locator("//div[@class='list-group']//a[text()='Logout']");
    }

    //methods/actions
    public boolean isMyAccountPageExists()
	{
		try 
		{
			return	msgHeading.isVisible();
		} 
		catch (Exception e) 
		{
			return false;
		}
	     
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
		
	}
}
