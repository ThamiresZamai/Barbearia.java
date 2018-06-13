<%@page import="br.com.barbearia.DB.ProdutoDB"%>
<%@page import="br.com.barbearia.entidade.Produto"%>
<%@page import="br.com.barbearia.DB.ServicoDB"%>
<%@page import="br.com.barbearia.entidade.Servico"%>
<%@page import="br.com.barbearia.DB.AgendaDB"%>
<%@page import="br.com.barbearia.entidade.Agenda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Bootstrap/bootstrap.css"/>
<script type="text/javascript" src="Bootstrap/jquery-3.3.1.min.js"></script> 
<script type="text/javascript" src="Bootstrap/js/bootstrap.js"></script> 
<title>Principal</title>

<style>
body {
   
    background-color: #000000;
	}
</style>

<script type="text/javascript">
function selecionado(idAgenda){
	$('#idAgendaSelecionada').val(idAgenda);
	console.log($('#idAgendaSelecionada').val());
}

function selecionaServicoProduto(){
	
	$('#idServicoSelecionada').val($("#sltServico option:selected").val());
	$('#idProdutoSelecionada').val($("#sltProduto option:selected").val());
	
	console.log($('#idServicoSelecionada').val());
}
</script>
</head>

<body>
<form action="ControllerServicosRealizados" method="post" class="espacamento">
<h1 style="color: #f9f9f9", align="center">Minha Barbearia</h1>

<table align="center" class="espacamento">
<tr>
<td>
<a href="CadastroCliente.jsp" class="btn btn-light" >Cadastro de Clientes</a>

<a href="CadastroServico.jsp" class="btn btn-light" >Cadastro de Serviços</a>

<a href="CadastroProduto.jsp" class="btn btn-light" >Cadastro de Produtos</a>

<a href="Agendamento.jsp" class="btn btn-light" >Agendamento</a>

<a href="Finalizados.jsp" class="btn btn-light" >Finalizados</a>
</td>
</tr>

</table>

<div align="center" class="espacamento">
	<img src="barbearia.png">
</div>

<div class="container">
<table class="table table-hover table-dark" align="center" >
  <thead>
    <tr>
      <th scope="col">Nome</th>
      <th scope="col">Data</th>
      <th scope="col">Hora</th>
    </tr>
  </thead>
  <tbody>
  
  <%for(Agenda agenda : new AgendaDB().all()) {%> 
    <tr> 
       <td><%=agenda.getIdCliente().getNome() %></td> 
      <td><%=agenda.getData() %></td> 
      <td><%=agenda.getHora() %></td> 

			<td>
      		<button type="button" class="btn btn-light" data-toggle="modal" data-target="#modalFinalizar" onclick="selecionado(<%=agenda.getId() %>)">Finalizar</button> 
      		</td>
     </tr> 
    <%} %> 
  </tbody>
</table>
</div>

<input type="hidden" id="idAgendaSelecionada" name="idAgendaSelecionada" />
<input type="hidden" id="idServicoSelecionada" name="idServicoSelecionada" />
<input type="hidden" id="idProdutoSelecionada" name="idProdutoSelecionada" />

<div class="modal fade" id="modalFinalizar" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> 
  <div class="modal-dialog" role="document"> 
    <div class="modal-content"> 
      <div class="modal-header"> 
        <h5 class="modal-title" id="exampleModalLabel">Finalizar Servico</h5> 
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"> 
          <span aria-hidden="true">&times;</span> 
        </button> 
      </div> 
      <div class="modal-body"> 
      <div class="form-group">
	      <select class="form-control" id="sltServico" name="sltServico">
	      
			<%for (Servico servico : new ServicoDB().all()){%>
				  <option value="<%=servico.id %>"><%=servico.nomeSer %></option>
		    <%}%>      
		  </select> 
		  <select class="form-control" id="sltProduto" name="sltProduto">
			<%for (Produto produto : new ProdutoDB().all()){%>
				  <option value="<%=produto.id %>"><%=produto.nomePro %></option>
		    <%}%>      
		  </select>
	   	 
	   </div>
	  <div class="form-group">
          <ul id="list" class="list-inline">
          </ul>
      </div>
      </div> 
      <div class="modal-footer"> 
        <button type="button" class="btn btn-dark" data-dismiss="modal">Cancelar</button> 
        <input type="submit" class="btn btn-light" value="Salvar"><br>
      </div> 
    </div> 
	</div> 
</div> 

</form>
</body>
</html>