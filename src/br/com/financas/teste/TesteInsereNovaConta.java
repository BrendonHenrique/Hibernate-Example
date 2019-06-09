package br.com.financas.teste;

import javax.persistence.EntityManager;
import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteInsereNovaConta {
	
	public static void main(String[] args) {

		Conta conta =  new Conta()
			.setAgencia("321")
			.setNumero("1232")
			.setBanco("Brasil")
			.setTitular("Joana");
		
		System.out.println(conta.toString());
		// Até aqui a instância da conta esta em 'Transient' , foi criada porém não houve commit 
		
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(conta);
		
		manager.getTransaction().commit();
		
		
		manager.close();
		//Aqui a conta esta em 'detached'  isso significa que o JPA já não pode mais alterar a conta.		
				
	}
}
