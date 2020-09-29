package br.com.fiap.tds.view;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Carro;
import br.com.fiap.tds.dao.CarroDao;

public class ExemploCarro {

	//Grava um carro no arquivo
	public static void main(String[] args) {
		
		String modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano"));
		String marca = JOptionPane.showInputDialog("Digite a marca");
		
		Carro carro = new Carro(modelo, ano, marca);
		
		CarroDao dao = new CarroDao();
		
		try {
			dao.gravar(carro);
			System.out.println("Carro gravado!");
			
			//Exibir todos os carros
			List<Carro> lista = dao.ler();
			
			//Representa uma String, porém não imutável, podemos modificar o seu valor
			StringBuffer texto = new StringBuffer();
			
			for (Carro c : lista) {
				texto.append(c.toString()).append("\n");
			}
			
			JOptionPane.showMessageDialog(null, texto);
			
		}catch(IOException e) {
			System.out.println("Erro ao gravar o carro");
		}
		
	} //main
	
}//classe
