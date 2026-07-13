package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseTest{
    
    @Test(dataProvider ="LoginData",dataProviderClass = DataProviders.class)
	public void verify_LoginDDT(String email,String pwd, String exp)
	{
		
		logger.info("*****StartingTC003LoginDDT*****");
		try 
		{
			
			logger.info("OpenHomePage");
			//Homepage
			HomePage hp=new HomePage(page);
			hp.clickMyAccount();
			hp.clickLogin();
			
			logger.info("OpenLoginPage");
			//LoginPage
			LoginPage lp=new LoginPage(page);
			lp.setEmailAddress(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			logger.info("OpenMyAccountPage");
			//MyAccountPage
			MyAccountPage map=new MyAccountPage(page);
			boolean targetpage=map.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("valid"))
			{
				if(targetpage==true)
				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else 
				{
					Assert.assertTrue(false);
				}
			}
		    
			if(exp.equalsIgnoreCase("invalid"))
			{
				if(targetpage==true)
				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else 
				{
					Assert.assertTrue(true);
				}
			}
					
			
		} 
		catch (Throwable e) 
		{
			
			Assert.fail("An Execption Occured:"+e.getMessage());
		}
		finally 
		{
			logger.info("*****FinishedTC003_LoginDDT*****");
		}
		
	
	}

}
