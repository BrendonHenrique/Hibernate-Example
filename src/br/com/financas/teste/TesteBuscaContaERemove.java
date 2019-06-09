package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteBuscaContaERemove {
	
	public static void main(String[] args) {
		Conta contaEncontrada = new Conta();
		
		
		EntityManager manager =  new JPAUtil().getEntityManager();
		
		contaEncontrada =  manager.find(Conta.class, 1);

		manager.getTransaction().begin();
		manager.remove(contaEncontrada);
		manager.getTransaction().commit();
		manager.close();
		
	}
}
