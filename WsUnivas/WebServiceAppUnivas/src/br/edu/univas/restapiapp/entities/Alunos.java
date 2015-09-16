package br.edu.univas.restapiapp.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.edu.univas.restapiapp.model.Aluno;

@XmlRootElement
public class Alunos {
	
	@XmlElement
	private List<Aluno> alunos;

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
