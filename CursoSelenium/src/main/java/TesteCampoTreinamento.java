import org.junit.Assert;
import org.junit.Ignore;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class TesteCampoTreinamento {

	String baseUrl = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
	WebDriver driver = new ChromeDriver();
	
	private void iniciaBrowser() 
	{
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void deveInteragirTextField() throws InterruptedException
	{
		this.iniciaBrowser();
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabriel");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Helko Meyer");
		Assert.assertEquals("Gabriel", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextArea() 
	{
		this.iniciaBrowser();
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de Area");
		Assert.assertEquals("Teste de Area", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
		
	}
	
	@Test
	public void deveInteragirComRadioButton() 
	{
		this.iniciaBrowser();
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox() 
	{
		this.iniciaBrowser();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComSelect() 
	{
		this.iniciaBrowser();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(4);
		//combo.selectByValue("especializacao");
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresDoSelect() 
	{
		this.iniciaBrowser();
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, ((java.util.List<WebElement>) options).size());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComMultiSelect() 
	{
		this.iniciaBrowser();
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		
		Assert.assertEquals(2, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(1, allSelectedOptions.size());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComBotoes() 
	{
		this.iniciaBrowser();
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	@Ignore
	public void deveInteragirComLink() 
	{
		this.iniciaBrowser();
		driver.findElement(By.linkText("Voltar")).click();
		Assert.fail();
		driver.quit();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() 
	{
		this.iniciaBrowser();
		driver.findElement(By.tagName("body"));
		//System.out.println(driver.findElement(By.tagName("body")).getText());
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Sobrenome:"));
		driver.quit();
		
	}
}












