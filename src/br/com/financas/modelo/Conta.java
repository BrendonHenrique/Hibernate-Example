package br.com.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Representação da classe como entidade dentro da tabela 
@Entity 
public class Conta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String agencia;
	private String banco;
	private String numero;
	private String titular;
	
	
	
	@Override
	public String toString() {
		return "Conta [id=" + id + ", agencia=" + agencia + ", banco=" + banco + ", numero=" + numero + ", titular="
				+ titular + "]";
	}

	public Conta() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public Conta setId(int id) {
		this.id = id;
		return this;
	}
	public String getTitular() {
		return titular;
	}
	public Conta setTitular(String titular) {
		this.titular = titular;
		return this;
	}
	public String getNumero() {
		return numero;
	}
	public Conta setNumero(String numero) {
		this.numero = numero;
		return this;
	}
	public String getBanco() {
		return banco;
	}
	public Conta setBanco(String banco) {
		this.banco = banco;
		return this;
	}
	public String getAgencia() {
		return agencia;
	}
	public Conta setAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}
	
	
}
