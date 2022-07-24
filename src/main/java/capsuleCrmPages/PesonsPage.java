package capsuleCrmPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CrmAutomation.CrmTest.TestBase;

public class PesonsPage extends TestBase {
		
	
	@FindBy(xpath="//a[contains(text(),' Add Person')]")
	WebElement addPerson;	
	
	@FindBy(xpath="//div[@class='select-box single-select chunky party-form-title']//div[@role='button']")
	WebElement title;
		
	@FindBy(xpath="//input[contains(@class,'first-name')]")
	WebElement firstName;
	
	@FindBy(xpath="//input[contains(@class,'last-name')]")
	WebElement lastName;
	
	@FindBy(xpath="//input[contains(@class,'job')]")
	WebElement jobTitle;
	
	@FindBy(xpath="//input[contains(@placeholder,'Find an organisation')]")
	WebElement orgnisation;
	
	@FindBy(xpath="//div[@class='filter-select__input-container']//input[contains(@id,'select-box-el-') ]")
	WebElement tags;
	
	@FindBy(xpath="//input[contains(@aria-label,'Phone number')]")
	WebElement phoneNumber;
	
	@FindBy(xpath="//input[contains(@class,'email')]")
	WebElement email;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	WebElement savePopup;
	
	@FindBy(xpath="//div[@class='party-details__text']//span[contains(text(),'')]")
	WebElement recordNameVerify;
	
	public PesonsPage()
	{
		PageFactory.initElements(driver, this);		
	}
		

	public boolean addPersonBtnVerify()
	{
		boolean addPersonBtn =addPerson.isDisplayed();
		return 	addPersonBtn;	
			
	}
	
	public void addPerson()
	{		
		addPerson.click();						
	}
	
	public void selectTitle(String setTitle)
	{
		title.click();
		List<WebElement> titleSelect = driver.findElements(By.xpath("//div[@class='select-box__options']/child::div"));
		System.out.println("title Options Size:-"+titleSelect.size());
		for(WebElement titleOpt : titleSelect)
		{
			String options = titleOpt.getText();
			if(options.contains(setTitle))
			{
				titleOpt.click();
			}//end if
		}//end for
		
	}//end method
	
	
	public void personDetails(String fName,String lName,String jobTit,String org,String tag,String phoneNum,String emailID)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		jobTitle.sendKeys(jobTit);
		
		orgnisation.sendKeys(org);
		orgnisation.sendKeys(Keys.TAB);
		
		tags.sendKeys(tag);
		tags.sendKeys(Keys.TAB);
		
		phoneNumber.sendKeys(phoneNum);
		email.sendKeys(emailID);
		
		
		save.click();
		
	}
	
	public void saveRecord()
	{
		savePopup.click();			
			
	}

	
	public String savedRecordVerify()
	{
		String personName =recordNameVerify.getText();
		System.out.println(personName);
		return personName;
			
	}
	
	

}
