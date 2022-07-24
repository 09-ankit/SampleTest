package capsuleCrmPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CrmAutomation.CrmTest.TestBase;

public class AccountsPage  extends TestBase {


	@FindBy(xpath="//span[@class='nav-bar-username' and text()]")
	WebElement accountName;


	@FindBy(xpath="//a[contains(text(),'Account Settings')]")
	WebElement navigateBackScreen;

	

	public AccountsPage()
	{
		PageFactory.initElements(driver, this);		
	}

	
	public String accountHolderNameVerify() throws InterruptedException
	{
		String accountNameVerfy = accountName.getText();
		return accountNameVerfy;
		
	}
	
	
	
	public void navToAccountSetting() throws InterruptedException
	{
		
		accountName.click();
		Thread.sleep(2000);
		List<WebElement> accountDropDown = driver.findElements(By.xpath("//div[@class='select-box__options bottom-right']/child::*"));
	
		for(WebElement select: accountDropDown)
		{
			String options = select.getText();
			if(options.contains("Account Settings"))
			{
				select.click();
				break;

			}//end if
										
			
		}//end for 

		
	}//end method

     
	public boolean accountSettingPageVerfy() 
	{
				
		boolean flag= driver.findElement(By.xpath("//div[@class='sp-portal__primary-items']//div[1]//a")).isDisplayed();		
		return flag;
	}
	
	
	
	
	public void headingVerification() throws InterruptedException 
	{
	
		for(int i=4; i<10; i++) // 5 no heading 
		{
			
			if(i==5)
			{
				continue;
				//5 does not contain heading as xpath
			}
			
			WebElement link= driver.findElement(By.xpath("//div[@class='sp-portal__primary-items']//div["+i+"]//a"));
			WebElement linkName = driver.findElement(By.xpath("//div[@class='sp-portal__primary-items']//div["+i+"]//a//h2"));
			String outerHeading = linkName.getText();

			
			
			
			
			try {
				System.out.println("Executing Try block");				
								
				clickOn(driver, link, 20);									
				String innerHeading =driver.findElement(By.xpath("//div[contains(@class,'sp-page__header')]//h1")).getText();
								
				if(outerHeading.contains(innerHeading))
				{
					System.out.println("Outer Heading Name is  :-"+outerHeading+ "And Inner Heading Name is:-"+innerHeading+ "  as Expected");
				}
				
				Thread.sleep(3000);	
				driver.navigate().back();
				//clickOn(driver, navigateBackScreen, 15);
				Thread.sleep(2500);		

			}//end try

			catch (StaleElementReferenceException e) {

				System.out.println("Executing Catch block");
				Thread.sleep(2500);
				System.out.println("Navigate to link:-"+linkName.getText());
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='sp-portal__primary-items']//div["+i+"]//a")).click();
				Thread.sleep(2200);
				String accountHeader =driver.findElement(By.xpath("//div[contains(@class,'sp-page__header')]//h1")).getText();
				System.out.println(accountHeader);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[contains(text(),'Account Settings')]")).click();				
				Thread.sleep(2500);

			}//end catch


		}//end for loop

	}//end method




}//end class
