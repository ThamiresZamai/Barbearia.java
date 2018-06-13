package br.com.barbearia.entidade;


public class ServicosRealizados {
	public int fkservico;
	public int fkproduto;
	public int fkagenda;
	
	public int getFkservico() {
		return fkservico;
	}
	public void setFkservico(int fkservico) {
		this.fkservico = fkservico;
	}
	public int getFkproduto() {
		return fkproduto;
	}
	public void setFkproduto(int fkproduto) {
		this.fkproduto = fkproduto;
	}
	public int getFkagenda() {
		return fkagenda;
	}
	public void setFkagenda(int fkagenda) {
		this.fkagenda = fkagenda;
	}
	public ServicosRealizados(int fkservico, int fkproduto, int fkagenda) {
		super();
		this.fkservico = fkservico;
		this.fkproduto = fkproduto;
		this.fkagenda = fkagenda;
	}
	public ServicosRealizados() {
		
	}
	
	
}