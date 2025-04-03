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
		String sql = "insert into moto(montadora, modelo, qtdAdesivos) values (?,?,?)";
		
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, moto.getMontadora());
			ps.setString(2, moto.getModelo());
			ps.setInt(3, moto.getQtdAdesivos());
			
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

