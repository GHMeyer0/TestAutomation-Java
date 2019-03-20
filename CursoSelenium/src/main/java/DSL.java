import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	public void selecionarSelect(String id, String valor) 
	{
		WebElement element = driver.findElement(By.id("id"));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
}
	
	

