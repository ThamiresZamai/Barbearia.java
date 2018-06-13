package br.com.barbearia.entidade;

public class ServicosRelatorio {
	public String nome;
	public String data;
	public String nomeSer;
	public String nomePro;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNomeSer() {
		return nomeSer;
	}
	public void setNomeSer(String nomeSer) {
		this.nomeSer = nomeSer;
	}
	public String getNomePro() {
		return nomePro;
	}
	public void setNomePro(String nomePro) {
		this.nomePro = nomePro;
	}
	public ServicosRelatorio(String nome, String data, String nomeSer, String nomePro) {
		super();
		this.nome = nome;
		this.data = data;
		this.nomeSer = nomeSer;
		this.nomePro = nomePro;
	}
	public ServicosRelatorio() {
		super();
	}
	
	

}
