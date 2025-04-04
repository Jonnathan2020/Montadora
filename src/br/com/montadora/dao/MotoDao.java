package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Moto;

public class MotoDao {
	private Connection con = null;
	
	public Connection getCon() {
		return con;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public MotoDao(Connection con) {
		setCon(con);
	}

	
	public String inserir(Moto moto) {
		String sql = "insert into moto(placa, montadora, modelo, qtdAdesivos) values (?,?,?,?)";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, moto.getPlaca());
			ps.setString(2, moto.getMontadora());
			ps.setString(3, moto.getModelo());
			ps.setInt(4, moto.getQtdAdesivos());
			
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
	
	public String deletar(Moto moto) {
		String sql = "delete from moto where placa = ?";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, moto.getPlaca());
	
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

