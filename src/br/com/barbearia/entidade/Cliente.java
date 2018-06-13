package br.com.barbearia.entidade;

public class Cliente {

	public int id;
	public String nome;
	public int telefone;
	public String dtnascimeto;
	
	public Cliente() {}
	
	public Cliente (int id) {
		this.id = id;
	}
	public Cliente (String nome) {
		this.nome = nome;
	}
	public Cliente(String nome, int telefone, String dtnascimeto) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.dtnascimeto = dtnascimeto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getDtnascimeto() {
		return dtnascimeto;
	}

	public void setDtnascimeto(String dtnascimeto) {
		this.dtnascimeto = dtnascimeto;
	}
	
}
