package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseTest;

public class TC002_LoginTest extends BaseTest{

    @Test(groups = {"Regression","Master"})
    public void verifyLogin()
    {
       logger.info("*****StaringTC002_LoginTest*****");
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
			lp.setEmailAddress(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			logger.info("OpenMyAccountPage");
			//MyAccountPage
			MyAccountPage map=new MyAccountPage(page);
			boolean targetpage=map.isMyAccountPageExists();
			System.out.println("Targetpage:"+targetpage);
			Assert.assertEquals(targetpage,true,"Login failed");
			logger.info("TestPassed");
        } 
       catch (Throwable e) 
		{
			logger.error("TestFailed:"+e.getMessage());
			Assert.fail();
		}
		finally 
		{
			logger.info("*****FinishedTC002_LoginTest*****");
		}
		
    }


    
}
