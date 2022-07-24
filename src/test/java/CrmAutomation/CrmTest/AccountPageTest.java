package CrmAutomation.CrmTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import capsuleCrmPages.AccountsPage;
import capsuleCrmPages.HomePage;
import capsuleCrmPages.LoginPage;

public class AccountPageTest extends TestBase {
	
	AccountsPage account;
	LoginPage login;
	HomePage homepage;
	
	
	public AccountPageTest()
	{
		super();		
	}
	
	
	@BeforeClass
	public void setup()
	{
		System.out.println("Test Case 2 Started");
		initialization();		
		login = new LoginPage();
		homepage = new HomePage();	
		account= new AccountsPage();	
		homepage=login.loginCredentials(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	
	/*
	 * validate every account page 
	 */
	
	
	@Test(priority=1)
	public void AccountVerifyAndSelect() throws InterruptedException
	{
		String accountName=account.accountHolderNameVerify();
		Assert.assertEquals(accountName, "Ankit Bhattad");			
		account.navToAccountSetting();
		boolean pageVerify=account.accountSettingPageVerfy();
		Assert.assertTrue(pageVerify,"Account Setting Page Not Found");
		
	}
	
	@Test(priority=2)
	public void verifyOuterHeadInnerHead() throws InterruptedException
	{
		
		account.headingVerification();
		
	}
	

}
