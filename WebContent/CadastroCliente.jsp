<%@page import="br.com.barbearia.DB.ClienteDB"%>
<%@page import="br.com.barbearia.entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Cliente</title>
<link rel="stylesheet" href="Bootstrap/bootstrap.css"/>
</head>
<body>
<form action="ControllerCliente" method="post">
<dir class="col-sm-6">
<%if (request.getAttribute("msg") != null){%>
<div class="alert alert-primary" role="alert">
  <%=request.getAttribute("msg")%>
</div>
<%} %>
</dir>
<dir class="col-sm-3">
<div>
<label>Nome:</label>
<input type="text" class="form-control" id="nome" name="nome"><br>
</div>
<div>
<label>Telefone:</label>
<input type="text" class="form-control" id="telefone" name="telefone"><br>
</div>
<div>
<label>Data nascimento:</label>
<input type="text" class="form-control" id="dtNascimento" name="dtNascimento"><br>
</div>
</div>
<input type="submit" class="btn btn-dark" value="Salvar"><br/>
</form>
<br/>
<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">Nome</th>
      <th scope="col">telefone</th>
      <th scope="col">Data_Nascimento</th>
    </tr>
  </thead>
  <tbody>
   <%for(Cliente cliente : new ClienteDB().all()) {%>
    <tr>
      <td><%=cliente.getNome() %></td>
      <td><%=cliente.getTelefone() %></td>
      <td><%=cliente.getDtnascimeto() %></td>
    </tr>
    <%} %>
 
  </tbody>
</table>
</dir>

<br>
<a href="Principal.jsp" class="btn btn-dark">Voltar</a>
</body>
</html>