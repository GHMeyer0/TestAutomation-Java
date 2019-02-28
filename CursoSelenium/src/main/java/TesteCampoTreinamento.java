import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabriel");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Helko Meyer");
		
		Assert.assertEquals("Gabriel", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		
		
		driver.quit();
	}
	
	public void deveInteragirComTextArea() 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
	}
}
