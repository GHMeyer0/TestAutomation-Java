import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.*;

public class TesteCadastro {

		String baseUrl = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
		WebDriver driver = new ChromeDriver();
		
		private void iniciaBrowser() 
		{
			driver.manage().window().maximize();
			driver.get(baseUrl);
		}
		
		@Test
		public void DeveRealizarCadastro() 
		{
			this.iniciaBrowser();
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Gabriel");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Meyer");
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
			new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");
		    
			new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
			new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Corrida");
			
			driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Deveria ter um layout melhor");
			
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			
			//Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).getText());
			Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
			Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Gabriel"));
			Assert.assertEquals("Sobrenome: Meyer", driver.findElement(By.id("descSobrenome")).getText());
			Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
			Assert.assertEquals("Comida: Carne Frango Pizza", driver.findElement(By.id("descComida")).getText());
			Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
			Assert.assertEquals("Esportes: Natacao Corrida", driver.findElement(By.id("descEsportes")).getText());
			Assert.assertEquals("Sugestoes: Deveria ter um layout melhor", driver.findElement(By.id("descSugestoes")).getText());
			
			driver.quit();
			
			
			
			
		}
}
