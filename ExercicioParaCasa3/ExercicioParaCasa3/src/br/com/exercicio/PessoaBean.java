package br.com.exercicio;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class PessoaBean  {
	
	private String nome;
	private String idade;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getIdade() {
		return idade;
	}
	
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String exibirDados() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (nome.equals("") || idade.equals("") || telefone.equals(""))
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Todos os campos são obrigatórios.", null));
		else
			{
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nome: " + nome, null));
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Idade: " + idade, null));
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone: " + telefone, null));
			}
		return "";
		}
	

}
