<%@page import="br.com.barbearia.DB.ServicoDB"%>
<%@page import="br.com.barbearia.entidade.Servico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Serviços</title>
<link rel="stylesheet" href="Bootstrap/bootstrap.css"/>
</head>
<body>
<form action="ControllerServico" method="post">
<dir class="col-sm-6"> 
<%if (request.getAttribute("msg") != null){%>
<div class="alert alert-primary" role="alert">
  <%=request.getAttribute("msg")%>
</div>
<%} %>
</dir>
<dir class="col-sm-3">
<div>
<label>Nome do serviço:</label>
<input type="text" class="form-control" id="nomeSer" name="nomeSer"><br>
</div>
<div>
<label>Preço:</label>
<input type="text" class="form-control" id="preco" name="preco"><br>
</div>
</div>
<input type="submit" class="btn btn-dark" value="Salvar"><br>
</form>
<br/>
<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">Nome do serviço</th>
      <th scope="col">Preço</th>
    </tr>
  </thead>
  <tbody>
   <%for(Servico servico : new ServicoDB().all()) {%>
    <tr>
      <td><%=servico.getNomeSer() %></td>
      <td><%=servico.getPreco() %></td>
    </tr>
    <%} %>
  </tbody>
</table>
</dir>


<br>
<a href="Principal.jsp" class="btn btn-dark">Voltar</a>
</body>
</html>