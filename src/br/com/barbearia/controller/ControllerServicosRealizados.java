package br.com.barbearia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.barbearia.DB.ServicosRealizadosDB;
import br.com.barbearia.entidade.ServicosRealizados;


@WebServlet("/ControllerServicosRealizados")
public class ControllerServicosRealizados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControllerServicosRealizados() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fkagenda = Integer.parseInt(request.getParameter("idAgendaSelecionada"));
		int fkservico = Integer.parseInt(request.getParameter("sltServico"));
		int fkproduto = Integer.parseInt(request.getParameter("sltProduto"));
		
		ServicosRealizados sr = new ServicosRealizados();
		sr.setFkagenda(fkagenda);;
		sr.setFkservico(fkservico);
		sr.setFkproduto(fkproduto);
		
		if (new ServicosRealizadosDB().insert(sr)) {

			request.setAttribute("msg", "Registro inserido com sucesso.");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Erro ao inserir registro.");
			request.getRequestDispatcher("Agendamento.jsp").forward(request, response);
		}
	}

}
