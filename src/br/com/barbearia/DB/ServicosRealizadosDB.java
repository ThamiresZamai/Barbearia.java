package br.com.barbearia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.barbearia.entidade.ServicosRealizados;
import br.com.barbearia.entidade.ServicosRelatorio;
import br.com.barbearia.util.Conexao;

public class ServicosRealizadosDB {

	Connection con;
	PreparedStatement ps;
	
public ServicosRealizadosDB(){
		
		con = Conexao.getConnection();
	}
	
public boolean insert(ServicosRealizados ServicosR) {
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("Insert into servicosrealizados (fkAgenda, fkSer, fkPro)");
			sb.append("value (?,?,?)");
			
			ps = this.con.prepareStatement(sb.toString());
			ps.setInt(1, ServicosR.getFkagenda());
			ps.setInt(2, ServicosR.getFkservico());
			ps.setInt(3, ServicosR.getFkproduto());
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

public List<ServicosRelatorio> all(){
	
	List<ServicosRelatorio> lstservicore = new ArrayList<>();
	String sql = "select c.nome , a.data, s.nomeSer, p.nomePro "+
			" FROM bdbarbearia.servicosrealizados sr"+
			" join agenda a on a.id = sr.fkAgenda"+
			" join servico s on s.id = sr.fkser"+
			" join produto p on p.id = sr.fkPro"+
			" join cliente c on c.id = a.idCliente";
	
	try {
		ps = this.con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			ServicosRelatorio sr = new ServicosRelatorio();
			sr.setNome(rs.getString("nome"));
			sr.setData(rs.getString("data"));
			sr.setNomeSer(rs.getString("nomeSer"));
			sr.setNomePro(rs.getString("nomePro"));
			lstservicore.add(sr);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return lstservicore;
}
}
