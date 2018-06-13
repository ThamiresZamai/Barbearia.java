<%@page import="br.com.barbearia.entidade.ServicosRelatorio"%>
<%@page import="br.com.barbearia.DB.ServicosRealizadosDB"%>
<%@page import="br.com.barbearia.entidade.ServicosRealizados"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Bootstrap/bootstrap.css"/>
<title>Finalizados</title>
</head>
<body>
<br/>
<a href="Principal.jsp" class="btn btn-dark">Voltar</a>
<br/>
<div class="container">
<table class="table table-hover table-dark" align="center">
  <thead>
    <tr>
      <th scope="col">Cliente</th>
      <th scope="col">Data</th>
      <th scope="col">Servico</th>
      <th scope="col">Produto</th>
    </tr>
  </thead>
  <tbody>
  
  <%for(ServicosRelatorio serrelatorio : new ServicosRealizadosDB().all()) {%> 
    <tr> 
       <td><%=serrelatorio.getNome() %></td>
       <td><%=serrelatorio.getData() %></td> 
      <td><%=serrelatorio.getNomeSer() %></td> 
      <td><%=serrelatorio.getNomePro() %></td> 		
    </tr> 
    <%} %> 
  </tbody>
</table>
</div>
</body>
</html>