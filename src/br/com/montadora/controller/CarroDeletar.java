package br.com.montadora.controller;

import java.sql.Connection;
import br.com.montadora.conexao.conexao;
import br.com.montadora.model.Carro;
import br.com.montadora.dao.CarroDao;

public class CarroDeletar {
	
	public static void main(String[] args) {
		Connection con = conexao.abrirConexao();
		
		Carro carro = new Carro();
		CarroDao carrodao = new CarroDao(con);
		
		carro.setPlaca(54321);
		System.out.println(carrodao.deletar(carro));
	
		conexao.fecharConexao(con);
	}
}
