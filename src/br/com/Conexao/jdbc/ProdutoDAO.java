package br.com.Conexao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.b.bens.Produto;

public class ProdutoDAO {

	//depois apagas (connection)
	private Connection con =  (Connection) Conexao.getConnection();

	
	public List<Produto> buscarProduto(Produto produto ){
		String sql ="SELECT * FROM PRODUTO";
		List<Produto> lista = new ArrayList<Produto>();
		try {
				
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while(resultados.next()){
			Produto prod = new Produto();
			prod.setId(resultados.getInt("id"));
			prod.setDescri��o(resultados.getString("descri��o"));
			prod.setPre�o(resultados.getInt("pre�o"));
					lista.add(prod);
				
			}
		
		
		} catch (SQLException e) {
			System.out.println("Erro - " + e.getMessage());
			
		}return lista;
	
	
	
	
	
}
}