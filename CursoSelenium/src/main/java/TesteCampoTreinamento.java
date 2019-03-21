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

	private String baseUrl = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	
	@Test
	public void deveInteragirTextField() throws InterruptedException
	{
		dsl.Escrever("elementosForm:nome", "Gabriel");
		dsl.Escrever("elementosForm:sobrenome", "Helko Meyer");
		Assert.assertEquals("Gabriel", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void deveInteragirComTextArea() 
	{
		dsl.Escrever("elementosForm:sugestoes", "Teste de Area");
		Assert.assertEquals("Teste de Area", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void deveInteragirComRadioButton() 
	{
		dsl.Clicar("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isMarcado("elementosForm:sexo:0"));
	}
	
	@Test
	public void deveInteragirComCheckBox() 
	{
		dsl.Clicar("elementosForm:comidaFavorita:0");
		Assert.assertTrue(dsl.isMarcado("elementosForm:comidaFavorita:0"));	
	}
	
	@Test
	public void deveInteragirComSelect() 
	{
		dsl.selecionarSelect("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("Superior", dsl.obterValorSelect("elementosForm:escolaridade"));
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
		dsl.selecionarSelect("elementosForm:esportes", "Natacao");
		dsl.selecionarSelect("elementosForm:esportes", "Corrida");
		
		
		//List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		
		//Assert.assertEquals(2, allSelectedOptions.size());
		
		dsl.desmarcarSelect("elementosForm:esportes", "Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(1, allSelectedOptions.size());
		
	}
	
	@Test
	public void deveInteragirComBotoes() 
	{
		
		dsl.Clicar("buttonSimples");
		Assert.assertEquals("Obrigado!", dsl.obterValorAtributo("buttonSimples","value"));
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












