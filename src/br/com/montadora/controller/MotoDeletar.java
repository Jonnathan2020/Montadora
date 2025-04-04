package br.com.montadora.controller;

import java.sql.Connection;
import br.com.montadora.conexao.conexao;
import br.com.montadora.model.Moto;
import br.com.montadora.dao.MotoDao;

public class MotoDeletar {
	
	public static void main(String[] args) {
		Connection con = conexao.abrirConexao();
		
		Moto moto= new Moto();
		MotoDao motodao = new MotoDao(con);
		
		moto.setPlaca(12345);
		System.out.println(motodao.deletar(moto));
	
		conexao.fecharConexao(con);
	}
}
