package br.com.univas.wsunivas.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "matriculas")
public class Matricula {

	private Long idMatricula;
	private int periodo;

	private Aluno aluno;
	private List<Disciplina> disciplinas;

	/*
	 * ID
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_matricula", nullable = false)
	public Long getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}

	/*
	 * Relacionamentos
	 */
	@ManyToOne
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@OneToMany(mappedBy = "matricula")
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	/*
	 * Campos
	 */
	@Column(name = "mat_periodo", nullable = false)
	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	/*
	 * hashCode e equals
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idMatricula == null) ? 0 : idMatricula.hashCode());
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
		Matricula other = (Matricula) obj;
		if (idMatricula == null) {
			if (other.idMatricula != null)
				return false;
		} else if (!idMatricula.equals(other.idMatricula))
			return false;
		return true;
	}

}
