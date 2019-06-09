package br.com.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
		
	//	Com o static eu garanto que a classe será instanciada em memória apenas uma vez.
	private static EntityManagerFactory  factory = Persistence.createEntityManagerFactory("financas");
	
	public EntityManager getEntityManager() {
		
		return factory.createEntityManager();
	}
	
}
