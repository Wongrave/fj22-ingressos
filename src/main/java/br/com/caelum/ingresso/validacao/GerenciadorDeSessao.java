package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}

	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova) {
		LocalDate hoje = LocalDate.now();
		LocalTime horarioSessaoExistente = sessaoExistente.getHorario();
		LocalTime horarioSessaoNova = sessaoNova.getHorario();
		boolean terminaAntes = sessaoNova.getHorarioTermino().isBefore(horarioSessaoExistente);
		boolean comecaDepois = sessaoExistente.getHorarioTermino().isBefore(horarioSessaoNova);
		if (terminaAntes || comecaDepois) {
			return false;
		}
		return true;
	}

	public boolean cabe(Sessao sessaoNova) {
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));
	}
}
