import org.junit.Assert;
import org.junit.Ignore;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteAlert {

	String baseUrl = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
	WebDriver driver = new ChromeDriver();
	
	private void iniciaBrowser() 
	{
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void DeveInteragirComAlertSimples() 
	{
		this.iniciaBrowser();
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		Assert.assertEquals("Alert Simples", text);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(text);
			
	}
	
	@Test
	public void DeveInteragirComAlertConfirm() 
	{
		this.iniciaBrowser();
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		Assert.assertEquals("Negado", alert.getText());
		alert.accept();
		driver.quit();
		
	}
	
	@Test
	public void DeveInteragirComAlertPrompt() 
	{
		this.iniciaBrowser();
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("50");
		alert.accept();
		
		Assert.assertEquals("Era 50?", alert.getText());
		alert.accept();
		
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
	}
}
