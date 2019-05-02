import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
	
	String baseUrl = "https://google.com";
	WebDriver driver;
	@Before
	public void inicializa() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	@Test
	public void teste() 
	{
		//System.setProperty("webdrive.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
	}
	
	
}
