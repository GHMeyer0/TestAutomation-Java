import org.openqa.selenium.WebDriver;
public class CampoTreinamentoPage {
	
	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) 
	{
		dsl= new DSL(driver);
	}
	public void setNome(String nome) {
		dsl.Escrever("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) 
	{
		dsl.Escrever("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() 
	{
		dsl.Clicar("elementosForm:sexo:0");
	}
	public void setSexoFeminino() 
	{
		dsl.Clicar("elementosForm:sexo:1");
	}
	public void setComidaCarne() 
	{
		dsl.Clicar("elementosForm:comidaFavorita:0");
	}
	public void setComidaFrango() 
	{
		dsl.Clicar("elementosForm:comidaFavorita:1");
	}
	public void setComidaPizza() 
	{
		dsl.Clicar("elementosForm:comidaFavorita:2");
	}
	public void setComidaVegetariano() 
	{
		dsl.Clicar("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String valor)
	{
		dsl.selecionarSelect("elementosForm:escolaridade", valor);
	}
	public void setEsporte(String valor) 
	{
		dsl.selecionarSelect("elementosForm:esportes", valor);
	}
	public void setSujestao(String texto) 
	{
		dsl.Escrever("elementosForm:sugestoes", texto);
	}
	
	public void cadastrar() 
	{
		dsl.Clicar("elementosForm:cadastrar");
	}
	
	
	
}
