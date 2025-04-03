package br.com.montadora.controller;

import java.sql.Connection;
import br.com.montadora.conexao.conexao;
import br.com.montadora.model.Carro;
import br.com.montadora.dao.CarroDao;

public class CarroInserir {
	
	public static void main(String[] args) {
		Connection con = conexao.abrirConexao();
		
		Carro carro = new Carro();
		CarroDao carrodao = new CarroDao(con);
		
		carro.setMontadora("GM");
		carro.setModelo("TRACKER");
		carro.setQtdPortas(4);
		System.out.println(carrodao.inserir(carro));
	
		conexao.fecharConexao(con);
	}
}
