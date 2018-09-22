package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {

	private Integer id;
	private LocalTime horario;
	private Sala sala;
	private Filme filme;

	public Sessao(LocalTime horario, Filme filme, Sala sala) {
		this.horario = horario;
		this.filme = filme;
		this.sala = sala;
	}

	public LocalTime getHorarioTermino() {
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
}
