package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Carro;

public class CarroDao {
	private Connection con = null;
	
	public Connection getCon() {
		return con;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public CarroDao(Connection con) {
		setCon(con);
	}
	
	public String inserir(Carro carro) {
		String sql = "insert into carro(montadora, modelo, qtdPortas) values (?,?,?)";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMontadora());
			ps.setString(2, carro.getModelo());
			ps.setInt(3, carro.getQtdPortas());
			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} 
			else {
				return "Erro inserir";
			}
			
		}
		
		 catch (SQLException e) {
			return e.getMessage();
		}
	}
}
