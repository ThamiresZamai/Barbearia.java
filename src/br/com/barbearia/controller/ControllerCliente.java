package br.com.barbearia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbearia.DB.ClienteDB;
import br.com.barbearia.entidade.Cliente;


@WebServlet("/ControllerCliente")
public class ControllerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ControllerCliente() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		int telefone = Integer.parseInt(request.getParameter("telefone"));
		String dtnascimeto = request.getParameter("dtNascimento");
		
		Cliente cli = new Cliente();
		cli.setNome(nome);
		cli.setTelefone(telefone);
		cli.setDtnascimeto(dtnascimeto);
		
	ClienteDB clientedb =  new ClienteDB();
		
		if (clientedb.insert(cli)) {

			request.setAttribute("msg", "Registro inserido com sucesso.");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Erro ao inserir registro.");
			request.getRequestDispatcher("CadastroCliente.jsp").forward(request, response);
		}
			
		}	

	}
