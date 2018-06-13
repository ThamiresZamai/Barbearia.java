package br.com.barbearia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.barbearia.entidade.Agenda;
import br.com.barbearia.entidade.Cliente;
import br.com.barbearia.util.Conexao;

public class AgendaDB {

	Connection con;
	PreparedStatement ps;
	
	public AgendaDB(){
		
		con = Conexao.getConnection();
	}
	public boolean insert(Agenda agenda) {
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("Insert into Agenda (idCliente, data, hora)");
			sb.append("value (?,?,?)");
			
			ps = this.con.prepareStatement(sb.toString());
			ps.setInt(1, agenda.getIdCliente().getId());
			ps.setString(2,agenda.getData());
			ps.setString(3,agenda.getHora());
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
public List<Agenda> all(){
		
		List<Agenda> lstagenda = new ArrayList<>();
		String sql = "Select a.id, c.nome, a.data, a.hora  From agenda a, cliente c where a.idCliente=c.id and a.id not in(select fkAgenda from servicosrealizados)";
		
		try {
			ps = this.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				Agenda ag = new Agenda();
				ag.setIdCliente(new Cliente(rs.getString("c.nome")));
				ag.setData(rs.getString("a.data"));
				ag.setHora(rs.getString("a.hora"));
				ag.setId(rs.getInt("a.id"));
				lstagenda.add(ag);
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return lstagenda;
	}
}
