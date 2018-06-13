package br.com.barbearia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.barbearia.entidade.Produto;
import br.com.barbearia.util.Conexao;

public class ProdutoDB {

		Connection con;
		PreparedStatement ps;
		
		public ProdutoDB(){
			
			con = Conexao.getConnection();
		}
		public boolean insert(Produto produto) {
			
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("Insert into produto(nomePro)");
				sb.append("value (?)");
				
				ps = this.con.prepareStatement(sb.toString());
				ps.setString(1, produto.getNomePro());
				ps.execute();
				
				return true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
		
		
	public List<Produto> all(){
			
			List<Produto> lstproduto = new ArrayList<>();
			String sql = "Select id, nomePro From produto";
			
			try {
				ps = this.con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					
					Produto pro = new Produto();
					pro.setNomePro(rs.getString("nomePro"));
					pro.setId(rs.getInt("id"));
					lstproduto.add(pro);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lstproduto;
		}
}
