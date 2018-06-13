package br.com.barbearia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbearia.DB.ProdutoDB;
import br.com.barbearia.entidade.Produto;

@WebServlet("/ControllerProduto")
public class ControllerProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControllerProduto() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePro = request.getParameter("nomePro");
		
		Produto pro = new Produto();
		pro.setNomePro(nomePro);
		
	ProdutoDB produtodb =  new ProdutoDB();
		
		if (produtodb.insert(pro)) {

			request.setAttribute("msg", "Registro inserido com sucesso.");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Erro ao inserir registro.");
			request.getRequestDispatcher("CadastroCliente.jsp").forward(request, response);
		}
			
		}	
	}


