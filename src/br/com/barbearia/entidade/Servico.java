package br.com.barbearia.entidade;

public class Servico {
	
	public int id;
	public String nomeSer;
	public double preco;
	
	public Servico() {
		
	}
	public Servico(String nomeSer) {
		this.nomeSer = nomeSer;
	}
	
	public Servico(String nomeSer, double preco) {
		super();
		this.nomeSer = nomeSer;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeSer() {
		return nomeSer;
	}

	public void setNomeSer(String nomeSer) {
		this.nomeSer = nomeSer;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
