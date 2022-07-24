package capsuleCrmPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import CrmAutomation.CrmTest.TestBase;

public class LoginPage extends TestBase {
	
	
	
	@FindBy(xpath="//input[contains(@id,'login:usernameDecorate:username')]")
	WebElement username;
	
	@FindBy(xpath="//input[contains(@id,'login:passwordDecorate:password')]")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@type,'submit')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='Capsule']")
	WebElement capsuleLogo;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean validateLogo()
	{				
		return capsuleLogo.isDisplayed();
	}
		
	
	public HomePage loginCredentials(String user , String pwd)
	{
		username.sendKeys(user);
		password.sendKeys(pwd);		
		loginBtn.click();
		return new HomePage();
			
	}
		
		
		
		
		

}
