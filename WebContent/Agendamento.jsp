<%@page import="br.com.barbearia.DB.ClienteDB"%>
<%@page import="br.com.barbearia.entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agendamento</title>
<link rel="stylesheet" href="Bootstrap/bootstrap.css"/>
</head>
<body>
<form action="ControllerAgenda" method="post">
<dir class="col-sm-6">
<%if (request.getAttribute("msg") != null){%>
<div class="alert alert-primary" role="alert">
  <%=request.getAttribute("msg")%>
</div>
<%} %>
</dir>
<dir class="col-sm-3">
<div class="form-group">
    <label for="SelectCliente">Cliente:</label>
    <select class="form-control" id="ClienteSelecionado" name="ClienteSelecionado">
    
    <option>Selecione</option>
    <% for(Cliente cliente : new ClienteDB().all()){%>
      <option value="<%=cliente.getId() %>"> <%=cliente.getNome() %></option>
      <%} %>
    </select>
  </div>
<div>
<label>Data:</label>
<input type="text" class="form-control" id="data" name="data"><br>
</div>
<div>
<label>Hora:</label>
<input type="text" class="form-control" id="hora" name="hora"><br>
</div>
</div>
<input type="submit" class="btn btn-dark" value="Salvar"><br>
</dir>


<br>
<a href="Principal.jsp" class="btn btn-dark">Voltar</a>
</form>
</body>
</html>