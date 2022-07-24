package capsuleCrmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CrmAutomation.CrmTest.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//span[text()='Ankit Bhattad']")
	WebElement accountName;
	
	@FindBy(xpath="//a[@id='ember7']")
	WebElement personsTab;
	

	
	public HomePage()
	{
		PageFactory.initElements(driver, this);		
	}
	
	
	public String getHomeTitle()
	{
		return driver.getTitle();	
	}
	
	public PesonsPage navigateToPersonsTab()
	{
		personsTab.click();
		return new PesonsPage();
	}
	

	
	
	
	

}
