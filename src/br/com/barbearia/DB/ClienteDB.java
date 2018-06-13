package br.com.barbearia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.barbearia.entidade.Cliente;
import br.com.barbearia.util.Conexao;

public class ClienteDB {

	Connection con;
	PreparedStatement ps;
	
	public ClienteDB(){
		
		con = Conexao.getConnection();
	}
	
	public boolean insert(Cliente cliente) {
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("Insert into Cliente(nome, telefone, dtnascimento)");
			sb.append("value (?,?,?)");
			
			
			ps = this.con.prepareStatement(sb.toString());
			ps.setString(1, cliente.getNome());
			ps.setInt(2, cliente.getTelefone());
			ps.setString(3, cliente.getDtnascimeto());
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
public List<Cliente> all(){
		
		List<Cliente> lstcliente = new ArrayList<>();
		String sql = "Select id, nome, telefone, dtNascimento From Cliente";
		
		try {
			ps = this.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getInt("telefone"));
				c.setDtnascimeto(rs.getString("dtNascimento"));
				
				lstcliente.add(c);
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return lstcliente;
	}
}
