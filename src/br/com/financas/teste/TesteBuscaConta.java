package br.com.financas.teste;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

public class TesteBuscaConta {
	public static void main(String[] args) {
				
		// As contas encontradas pelo metodo find , estão no estado MANAGED 
		// Isso significa que essas contas estão sincronizadas com a JPA 
		// Portanto ao utilizar um commit para o JPA as contas serão automaticamente atualizadas
		// Caso tenha mais de um atributo alterado utilizando o SET o update irá ser efetuado apenas para
		// os valores que estiverem diferentes.
		
		
		EntityManager manager =  new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta contaEncontrada = manager.find(Conta.class, 1);
		
		contaEncontrada.setTitular("Brendon Henrique");
		contaEncontrada.setBanco("Banrisul");
		
		
		manager.getTransaction().commit();
		manager.close();
				
		//Aqui a conta já não é mais sincronizada com a API, esta em 'detached' , para acessar novamente é preciso utilizar merge()
		
		
		EntityManager manager2 = new JPAUtil().getEntityManager();
		manager2.getTransaction().begin();
		//Após iniciar a transação com o gerênciador de entidades , e utilizar o Begin , todas e quaisquer alterações 
		//na instância do objeto encontrado , será passado para 'Transient' , porém isso só poderá acontecer caso utilize o merge()
		//para transformar uma instância de detached para managed.
		
		contaEncontrada.setTitular("Brendon henrique santos silva");
		manager2.merge(contaEncontrada);
		
		manager2.getTransaction().commit();
		manager2.close();
		
	}
}
