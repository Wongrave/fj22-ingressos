package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by nando on 03/03/17.
 */
@Entity
public class Filme {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private Duration duracao;
	private String genero;

	private BigDecimal preco;

	/**
	 * @deprecated hibernate only
	 */
	public Filme() {
	}

	public Filme(String nome, Duration duracao, String genero, BigDecimal preco) {
		this.nome = nome;
		this.duracao = duracao;
		this.genero = genero;
		this.preco = preco;
	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Filme(String nome, Duration duracao, String genero) {
		this.nome = nome;
		this.duracao = duracao;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Duration getDuracao() {
		return duracao;
	}

	public void setDuracao(long duracao) {
		this.duracao = Duration.ofMinutes(duracao);
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
