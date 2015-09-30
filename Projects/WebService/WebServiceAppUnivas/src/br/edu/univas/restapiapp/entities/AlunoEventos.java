package br.edu.univas.restapiapp.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.edu.univas.restapiapp.model.Aluno;

@XmlRootElement
public class AlunoEventos {

	@XmlElement
	private List<Aluno> aluno;

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

}
