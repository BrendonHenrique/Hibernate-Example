package br.com.financas.teste;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteBuscasComJPQL {
	public static void main(String[] args) {
		
		
		EntityManager manager =   new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta().setId(3);
		
		
		//Select com where e id 		
		String jpqlWithId = "select m from Movimentacao m where m.conta.id = 3";
				

		//Select com where e Object conta		
		String jpqlWithObject = "select m from Movimentacao m where m.conta = :pConta";

		
		//Select * from 		
		String jpqlAll = "select m from Movimentacao m";
				
		//Select com where e Object conta utilizando ordenação descendente
		String jpqlWithObjectDescOrder = "select m from Movimentacao m where m.conta = :pConta"
				+ " order by m.valor desc";
		
		//Select com where e Object conta utilizando ordenação descendente e passando tipo da movimentacao
		String DescOrderAndTipoMovimentacao = "select m from Movimentacao m where m.conta = :pConta"
				+ " and m.tipo = :pTipo"
				+ " order by m.valor desc";
		
	
		
		Query query = manager.createQuery(DescOrderAndTipoMovimentacao);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao: resultados) {
			System.out.println(movimentacao);
		}
		
		manager.getTransaction().commit();
		manager.close();
	}
}
