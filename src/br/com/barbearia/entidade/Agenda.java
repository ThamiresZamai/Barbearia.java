package br.com.barbearia.entidade;

public class Agenda {

	public int id;
	public Cliente idCliente;
	public String data;
	public String hora;

	
	public Agenda() {
		
	}
	
	public Agenda(int id, Cliente idCliente, String data, String hora) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.data = data;
		this.hora = hora;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	
}
