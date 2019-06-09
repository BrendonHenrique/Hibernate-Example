package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		
		Categoria c1 =  new Categoria("Viagem");
		Categoria c2 =  new Categoria("Alimentos");
		Categoria c3 =  new Categoria("Roupas");
		Conta conta = new Conta().setId(3);
		
		
		Movimentacao movimentacao =  new Movimentacao()
				.setData(Calendar.getInstance())
				.setDescricao("Compra de roupas na C&A")
				.setTipo(TipoMovimentacao.SAIDA)
				.setValor(new BigDecimal("130.00"))
				.setCategorias(Arrays.asList(c1,c3))
				.setConta(conta);

		
		Movimentacao movimentacao2 =  new Movimentacao()
				.setData(Calendar.getInstance())
				.setDescricao("Compra de um BicMag no McDonalts")
				.setTipo(TipoMovimentacao.SAIDA)
				.setValor(new BigDecimal("2030.00"))
				.setCategorias(Arrays.asList(c1,c2))
				.setConta(conta);
		
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(c1);
		manager.persist(c2);
		manager.persist(c3);
		
		manager.persist(movimentacao);
		manager.persist(movimentacao2);
		
		
		manager.getTransaction().commit();
		manager.close();
		
		
		
		
		
		
		
		
	}
}
