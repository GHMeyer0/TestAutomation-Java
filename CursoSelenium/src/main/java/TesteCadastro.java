import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.*;

public class TesteCadastro {

		String baseUrl = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
		WebDriver driver = new ChromeDriver();
		private CampoTreinamentoPage page;
		
		@Before
		public void inicializa() 
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseUrl);
			DSL dsl = new DSL(driver);
		}
		
		@After
		public void finaliza() {
			driver.quit();
		}
		
		@Test
		public void DeveRealizarCadastro() 
		{
			page.setNome("Gabriel");
			page.setSobrenome("Helko Meyer");
			page.setSexoMasculino();
			page.setComidaCarne();
			page.setComidaFrango();
			page.setComidaPizza();
			page.setEscolaridade("Superior");
			page.setEsporte("Natacao");
			page.setEsporte("Corrida");
			page.setSujestao("Deveria ter um layout melhor");
			page.cadastrar();
			
			//Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).getText());
			Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
			Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Gabriel"));
			Assert.assertEquals("Sobrenome: Meyer", driver.findElement(By.id("descSobrenome")).getText());
			Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
			Assert.assertEquals("Comida: Carne Frango Pizza", driver.findElement(By.id("descComida")).getText());
			Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
			Assert.assertEquals("Esportes: Natacao Corrida", driver.findElement(By.id("descEsportes")).getText());
			Assert.assertEquals("Sugestoes: Deveria ter um layout melhor", driver.findElement(By.id("descSugestoes")).getText());
			
		}
}
