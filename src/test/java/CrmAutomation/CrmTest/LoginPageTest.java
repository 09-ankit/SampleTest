package CrmAutomation.CrmTest;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import capsuleCrmPages.HomePage;
import capsuleCrmPages.LoginPage;
import capsuleCrmPages.PesonsPage;
import crmUtilities.Utilities;

public class LoginPageTest extends TestBase {
	
	LoginPage login;
	HomePage homepage;
	PesonsPage personpage;
	Utilities utility;
	
	public LoginPageTest()
	{
		super();		
	}
	
	
		
	@BeforeMethod
	public void setup()
	{
		System.out.println("Test Case 1 Started");
		initialization();
		utility = new Utilities();	
		login = new LoginPage();
		homepage = new HomePage();
		personpage = new PesonsPage();
		
	}
	
	
	@DataProvider
	public Iterator<Object[]> getSheetdata()
	{
		ArrayList<Object[]> testData =Utilities.getDatafromExcel();	
		return testData.iterator();
		
	}


	
	
	@Test(priority=1 , dataProvider="getSheetdata")
	public void loginAndAddPerson(String ftName, String ltName, String jobTit, String orgn, String tagss, String phoneNum, String email)
	{
		boolean flag =login.validateLogo();	
		Assert.assertTrue(flag);		
		homepage=login.loginCredentials(prop.getProperty("username"), prop.getProperty("password"));		
		String  title =homepage.getHomeTitle();		
		Assert.assertEquals(title, "Dashboard | Shatam CRM");
		
		personpage = homepage.navigateToPersonsTab();		
		boolean btnFound =personpage.addPersonBtnVerify();
		Assert.assertTrue(btnFound);
		personpage.addPerson();
		personpage.selectTitle("Mr");	
		personpage.personDetails(ftName, ltName, jobTit, orgn, tagss, phoneNum, email);
		personpage.saveRecord();		
		String personName=personpage.savedRecordVerify();
		Assert.assertEquals(personName, "Mr Anjan Sharma");
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Test Case 1 Completed");	
	}
	

}
