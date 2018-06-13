package br.com.barbearia.entidade;

public class Produto {
	public int id;
	public String nomePro;

	public Produto() {
		
	}
	public Produto(String nomePro) {
		super();
		this.nomePro = nomePro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomePro() {
		return nomePro;
	}

	public void setNomePro(String nomePro) {
		this.nomePro = nomePro;
	}

}
