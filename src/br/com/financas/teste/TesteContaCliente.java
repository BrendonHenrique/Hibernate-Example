package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Cliente;
import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {
		

		Conta conta = new Conta()
				.setId(8);
		
		Cliente cliente = new Cliente()
				.setNome("joao")
				.setEndereco("Rua caxinguele 153")
				.setProfissao("Desenvolvedor FullStack")
				.setConta(conta);
		
		
		EntityManager manager =  new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(cliente);
		
		
		manager.getTransaction().commit();
		manager.close();
		
		
		
	}
}
