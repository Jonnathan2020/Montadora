package br.com.montadora.controller;

import java.sql.Connection;
import br.com.montadora.conexao.conexao;
import br.com.montadora.model.Moto;
import br.com.montadora.dao.MotoDao;

public class MotoInserir {
	
	public static void main(String[] args) {
		Connection con = conexao.abrirConexao();
		
		Moto moto= new Moto();
		MotoDao motodao = new MotoDao(con);
		
		moto.setMontadora("HONDA");
		moto.setModelo("TWISTER");
		moto.setQtdAdesivos(6);
		System.out.println(motodao.inserir(moto));
	
		conexao.fecharConexao(con);
	}
}
