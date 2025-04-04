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
		String sql = "insert into carro(placa,montadora, modelo, qtdPortas) values (?,?,?,?)";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carro.getPlaca());
			ps.setString(2, carro.getMontadora());
			ps.setString(3, carro.getModelo());
			ps.setInt(4, carro.getQtdPortas());
			
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
	
	public String deletar(Carro carro) {
		String sql = "delete from carro where placa = ?";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, carro.getPlaca());
	
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} 
			else {
				return "Erro ao deletar";
			}
			
		}
		
		 catch (SQLException e) {
			return e.getMessage();
		}
	}
	
}
