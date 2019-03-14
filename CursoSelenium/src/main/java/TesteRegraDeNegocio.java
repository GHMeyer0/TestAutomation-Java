import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.junit.*;

public class TesteRegraDeNegocio {
	String baseUrl = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
	WebDriver driver = new ChromeDriver();
	
	private void iniciaBrowser() 
	{
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void DeveTestarRegradeNegocio() 
	{
		this.iniciaBrowser();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabriel");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		alert.accept();
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Meyer");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		alert.accept();
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		alert.accept();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Corrida");
		new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		alert.accept();
		new Select(driver.findElement(By.id("elementosForm:esportes"))).deselectByVisibleText("O que eh esporte?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.quit();
		
		
		

		
		
		
		
	}
	
}
