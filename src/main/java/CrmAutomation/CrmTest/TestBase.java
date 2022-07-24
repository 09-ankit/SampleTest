package CrmAutomation.CrmTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {


	public static WebDriver driver;
	public static Properties prop;

	
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\AnkitNewWorkSpace\\CrmTest\\src\\main\\java\\com\\crm\\config\\config.properties");
			prop.load(ip);			
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();			
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void  initialization(){
		
			String browserName = prop.getProperty("browser");
			//change path
			if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\sel fils\\Ankit\\chromedriver.exe");
			driver = new ChromeDriver(); 
									
		}
						

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
			driver.get(prop.getProperty("url"));
			
			
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value)
	{
		new WebDriverWait(driver,timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	
	public static void clickOn(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver,timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	
	
}
