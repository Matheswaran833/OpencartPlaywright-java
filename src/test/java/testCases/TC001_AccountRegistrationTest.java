package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseTest;

public class TC001_AccountRegistrationTest extends BaseTest{
    
    
    
    @Test(groups = {"Sanity","Master"})
    public void verifyaccountRegistration()
    {
        logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
    try
    {
        HomePage hp=new HomePage(page);
        hp.clickMyAccount();
        logger.info("Clicked on MyAccount Link.. ");
        hp.clickRegister();
        logger.info("Clicked on Register Link.. ");

        AccountRegistrationPage regpage=new AccountRegistrationPage(page);
        logger.info("Providing customer details...");
        regpage.setFirstName(randomString().toUpperCase());
        regpage.setLastName(randomString().toUpperCase());
        regpage.setEmail(randomString()+"@gmail.com");
        regpage.setTelephone(randomNumber());
        String password=randomAlphaNumaricString();
        regpage.setPassword(password);
        regpage.setConfirmPassword(password);
        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        logger.info("Validating expected message..");
        String confmsg=regpage.getConfirmationmsg();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        logger.info("Test passed");
    } 
	catch (Throwable e)
	{
		logger.error("Test failed: " + e.getMessage());
		Assert.fail("Test failed: " + e.getMessage());
		
	} 
	finally 
	{
	logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
    }


}  