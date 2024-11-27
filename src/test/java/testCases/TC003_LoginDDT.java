package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
/*Data is valid -login success-test pass
 * Data is valid-- login failed -test fail
 * 
 * Data is invalid-login success -test fail-logout
 * data is invalid-login failed-test pass
 * 
 */

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven") //if the data providers created in different package
	public void verify_LoginDDT(String email,String pwd,String exp){
		
        logger.info("****************starting TC003_LoginDDT*******");
        
        try {
		
        //Homepage
		HomePage hp=new HomePage(driver);
		logger.info("1.On home page, Click Myaccount link--> Login link");
		hp.clickMyAccount();
		hp.clickLogin();
				
		
		//loginpage
		LoginPage lp=new LoginPage(driver);
		logger.info("2.Take  email from Data provider");
		lp.setEmail(email);
		logger.info("3.Take password from Data provider");
		lp.setpassword(pwd);
		logger.info("4.click on login button");
		lp.LoginClick();
		
		
		//Myaccount page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountExists();
		logger.info("5.Naviagte to My account page");
		
		/*Data is valid -login success-test pass
		 * Data is valid-- login failed -test fail
		 * 
		 * Data is invalid-login success -test fail-logout
		 * data is invalid-login failed-test pass
		 */

		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				macc.logoutClick();
				Assert.assertTrue(true); // test pass
				
			}
			else
			{
				Assert.assertTrue(false); //test fail
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.logoutClick();
				Assert.assertTrue(false);//test fail
				
			}
			else
			{
				Assert.assertTrue(true);  //test pass
			}
		}
        }
		
		 catch (Exception e) {
			Assert.fail();
		}
	    	
        logger.info("****************finished TC003_LoginDDT*******");
	}
}	

		
		
	


