package br.edu.univas.restapiapp.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.edu.univas.restapiapp.model.Aluno;
import br.edu.univas.restapiapp.model.Disciplina;
import br.edu.univas.restapiapp.model.Periodo;

@XmlRootElement
public class AlunoDisciplinas {

	@XmlElement
	private Aluno aluno;

	@XmlElement
	private Periodo periodo;

	@XmlElement
	private List<Disciplina> disciplinas;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}


}
