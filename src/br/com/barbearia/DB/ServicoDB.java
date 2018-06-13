package br.com.barbearia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.barbearia.entidade.Servico;
import br.com.barbearia.util.Conexao;

public class ServicoDB {

	Connection con;
	PreparedStatement ps;
	
	public ServicoDB(){
		
		con = Conexao.getConnection();
	}
	public boolean insert(Servico servico) {
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("Insert into servico (nomeSer, preco)");
			sb.append("value (?,?)");
			
			ps = this.con.prepareStatement(sb.toString());
			ps.setString(1, servico.getNomeSer());
			ps.setDouble(2, servico.getPreco());
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
public List<Servico> all(){
		
		List<Servico> lstservico = new ArrayList<>();
		String sql = "Select id, nomeSer, preco From servico";
		
		try {
			ps = this.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				Servico s = new Servico();
				s.setNomeSer(rs.getString("nomeSer"));
				s.setPreco(rs.getDouble("preco"));
				s.setId(rs.getInt("id"));
				lstservico.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstservico;
	}
}
