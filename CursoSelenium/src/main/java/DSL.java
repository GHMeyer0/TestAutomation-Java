import java.lang.reflect.Array;
import java.util.List;

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
	
	public String obterValorAtributo(String id, String atributo) 
	{
		return driver.findElement(By.id(id)).getAttribute(atributo);
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
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void desmarcarSelect(String id, String valor) 
	{
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String obterValorSelect(String id) 
	{
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	public String obterValoresSelect(String id) 
	{
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getOptions().toString();

	}
	public String obterValoresMarcadosSelect(String id) 
	{
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getAllSelectedOptions();
		
	}
	
	public int obterQuantidadeOpçoesSelect(String id) 
	{
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getOptions();
		return allSelectedOptions.size(); 
	}
	
	public int obterQuantidadeOpçoesSelecionadas(String id) 
	{
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		return allSelectedOptions.size(); 
	}
	public void clicarLink(String texto) 
	{
		driver.findElement(By.linkText(texto)).click();
	}
	
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}
}
	
	

