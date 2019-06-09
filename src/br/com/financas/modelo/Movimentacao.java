package br.com.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;

@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id ;
	
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	private String descricao;

	@ManyToOne
	private Conta conta;
	
	
	@ManyToMany
	private List<Categoria> categorias;
	
	
	
	public Movimentacao() {
		super();
	}
	
	
	
	
	public Integer getId() {
		return id;
	}

	public Movimentacao setId(Integer id) {
		this.id = id;
		return this;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Movimentacao setValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public Movimentacao setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
		return this;
	}

	public Calendar getData() {
		return data;
	}

	public Movimentacao setData(Calendar data) {
		this.data = data;
		return this;
	}

	public String getDescricao() {
		return descricao;
	}

	public Movimentacao setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}


	public Conta getConta() {
		return conta;
	}

	public Movimentacao setConta(Conta conta) {
		this.conta = conta;
		return this;
	}
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public Movimentacao setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", valor=" + valor + ", tipo=" + tipo + ", data=" + data + ", descricao="
				+ descricao + "]";
	}
	
	
}
