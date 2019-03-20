import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void Escrever(String id_campo, String texto) 
	{
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) 
	{
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void Clicar(String id) 
	{
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isMarcado(String id) 
	{
		return driver.findElement(By.id(id)).isSelected();

	}
}
	
	

