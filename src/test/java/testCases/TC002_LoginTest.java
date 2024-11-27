package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****************starting TC002_LoginTest*******");
		
		try {
		//Homepage
		HomePage hp=new HomePage(driver);
		
	
		
		logger.info("1.On home page, Click Myaccount link--> Login link");
		hp.clickMyAccount();
		
		hp.clickLogin();
		Thread.sleep(3000);
		//loginpage
		LoginPage lp=new LoginPage(driver);
		
		logger.info("2.Enter valid email");
		lp.setEmail(p.getProperty("email"));
		
		logger.info("3.Enter valid password");
		lp.setpassword(p.getProperty("password"));
		
		logger.info("4.click on login button");
		lp.LoginClick();
		
		
		//Myaccount page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountExists();
		logger.info("5.Naviagte to My account page");
		//Assert.assertEquals(targetPage, true,"Login failed");
		Assert.assertTrue(targetPage);
		}
		
		catch (Exception e) {
			Assert.fail();
			
		}
		
		
		logger.info("*********finished TC002_LoginTest*************");
		}
		
		
	}


