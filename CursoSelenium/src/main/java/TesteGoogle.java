import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() 
	{
		//System.setProperty("webdrive.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
	
}
