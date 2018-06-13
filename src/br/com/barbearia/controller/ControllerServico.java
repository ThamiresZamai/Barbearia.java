package br.com.barbearia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbearia.DB.ServicoDB;
import br.com.barbearia.entidade.Servico;

@WebServlet("/ControllerServico")
public class ControllerServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControllerServico() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeSer = request.getParameter("nomeSer");
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		Servico ser = new Servico();
		ser.setNomeSer(nomeSer);
		ser.setPreco(preco);
		
		
	ServicoDB servicodb =  new ServicoDB();
		
		if (servicodb.insert(ser)) {

			request.setAttribute("msg", "Registro inserido com sucesso.");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Erro ao inserir registro.");
			request.getRequestDispatcher("CadastroCliente.jsp").forward(request, response);
		}
			
		}	
	}

