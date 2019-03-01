import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	String baseUrl = "file://" + System.getProperty("user.dir") + "/src/main/resources/componentes.html";
	WebDriver driver = new ChromeDriver();
	
	public void iniciaBrowser() 
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
	
}
