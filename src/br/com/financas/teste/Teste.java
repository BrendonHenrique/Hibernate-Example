package br.com.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.financas.modelo.Conta;

public class Teste {
	
	public static void main(String[] args) {

		Conta conta =  new Conta()
			.setAgencia("0495")
			.setNumero("123")
			.setBanco("Caixa")
			.setTitular("Brendon");
		
		System.out.println(conta.toString());
		
		EntityManagerFactory  emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}
}
