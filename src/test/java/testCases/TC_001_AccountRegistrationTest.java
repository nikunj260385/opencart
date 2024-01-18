package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration()
	{
       logger.info("**** starting TC_001_AccountRegistrationTest  *****");
		
		logger.debug("application logs started......");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
        logger.info("Clicked on registration link");
		
		
		logger.info("Entering customer details.. ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		Thread.sleep(5000);
		logger.info("Set Privacy policy");
		regpage.setPrivacyPolicy();
		logger.info("Before clicking continue");
		Thread.sleep(5000);
		regpage.clickContinue();
		logger.info("clicked on continue..");
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message..");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			logger.debug("debug logs....");
			Assert.fail();
		}
		
	}
	
	
	
	
}








