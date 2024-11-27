package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.AccountRegistrationPage;
public class TC001_AccountRegistrationTest extends BaseClass {

    
	@Test(groups={"Regression","Master"})
	public void Verify_account_registration()
	{
	try {	
		logger.info("************************ Starting TC001_AccountRegistrationTest**************************************");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on Registration link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Filling form.....");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.ClickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			
		}
		else 
		{
			logger.error("Test failed..");
			logger.debug ("Debug logs..");
			Assert.assertTrue(false);
			
		}
	}

		catch(Exception e)
	  {
				Assert.fail();
	  }
	
	
	}
}
