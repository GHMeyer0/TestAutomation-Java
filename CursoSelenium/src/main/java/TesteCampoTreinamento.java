import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
	public void deveInteragirTextField() throws InterruptedException
	{
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabriel");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Helko Meyer");
		Assert.assertEquals("Gabriel", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
	}
	
	@Test
	public void deveInteragirComTextArea() 
	{
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de Area");
		Assert.assertEquals("Teste de Area", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		
	}
	
	@Test
	public void deveInteragirComRadioButton() 
	{
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
	}
	
	@Test
	public void deveInteragirComCheckBox() 
	{
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		
	}
	
	@Test
	public void deveInteragirComSelect() 
	{
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(4);
		//combo.selectByValue("especializacao");
		combo.selectByVisibleText("Superior");
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		
	}
	
	@Test
	public void deveVerificarValoresDoSelect() 
	{
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, ((java.util.List<WebElement>) options).size());
		
	}
	
	@Test
	public void deveInteragirComMultiSelect() 
	{
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		
		Assert.assertEquals(2, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(1, allSelectedOptions.size());
		
	}
	
	@Test
	public void deveInteragirComBotoes() 
	{
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComLink() 
	{
		
		driver.findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
	}
	
	@Test
	public void deveBuscarTextosNaPagina() 
	{
		//driver.findElement(By.tagName("body"));
		//System.out.println(driver.findElement(By.tagName("body")).getText());
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Sobrenome:"));
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		
		
	}
}












