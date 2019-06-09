package br.com.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

public class TesteDeRelacionamentoMuitosParaUm {

	public static void main(String[] args) {
		
		Conta conta = new Conta()
				.setAgencia("0495")
				.setBanco("Caixa")
				.setNumero("000814579")
				.setTitular("Brendon Henrique");
		
		
		Movimentacao movimentacao =  new Movimentacao()
				.setData(Calendar.getInstance())
				.setDescricao("Churrascaria")
				.setTipo(TipoMovimentacao.SAIDA)
				.setValor(new BigDecimal("210.23"))
				.setConta(conta);
		
		
		EntityManager manager =  new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(movimentacao);
		
		
		manager.getTransaction().commit();
		manager.close();
		
	}

}
