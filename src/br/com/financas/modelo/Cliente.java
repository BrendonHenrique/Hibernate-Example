package br.com.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String profissao;
	private String endereco;
	
	@JoinColumn(unique=true)
	@OneToOne
	private Conta conta;
	
	
	public Conta getConta() {
		return conta;
	}
	public Cliente setConta(Conta conta) {
		this.conta = conta;
		return this;
	}
	public Integer getId() {
		return id;
	}
	public Cliente setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getNome() {
		return nome;
	}
	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}
	public String getProfissao() {
		return profissao;
	}
	public Cliente setProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}
	public String getEndereco() {
		return endereco;
	}
	public Cliente setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", profissao=" + profissao + ", endereco=" + endereco + "]";
	}
	
	
}
