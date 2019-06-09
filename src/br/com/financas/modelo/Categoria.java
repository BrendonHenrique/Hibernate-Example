package br.com.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	@Deprecated
	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.nome =  nome;
	}
	
		
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	
	public Categoria setId(Integer id) {
		this.id =  id;
		return this;
	}
	
	public Categoria setNome(String nome) {
		this.nome =  nome;
		return this;
	}
	

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
