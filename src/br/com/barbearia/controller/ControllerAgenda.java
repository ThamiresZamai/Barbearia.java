package br.com.barbearia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbearia.DB.AgendaDB;
import br.com.barbearia.entidade.Agenda;
import br.com.barbearia.entidade.Cliente;

@WebServlet("/ControllerAgenda")
public class ControllerAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControllerAgenda() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idcliente = Integer.parseInt(request.getParameter("ClienteSelecionado"));
		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		
		Agenda a = new Agenda();
		a.setIdCliente(new Cliente(idcliente));
		a.setData(data);
		a.setHora(hora);
		
		if (new AgendaDB().insert(a)) {

			request.setAttribute("msg", "Registro inserido com sucesso.");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Erro ao inserir registro.");
			request.getRequestDispatcher("Agendamento.jsp").forward(request, response);
		}
	}

}
