package br.com.univas.wsunivas.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "faltas")
public class Falta {

	private Long idFaltas;
	private Date data;

	private Disciplina disciplina;

	/*
	 * ID
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_falta", nullable = false)
	public Long getIdFaltas() {
		return idFaltas;
	}

	public void setIdFaltas(Long idFaltas) {
		this.idFaltas = idFaltas;
	}

	/*
	 * Relacionamentos
	 */
	@ManyToOne
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	/*
	 * Campos
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "fal_data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/*
	 * hashCode e equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFaltas == null) ? 0 : idFaltas.hashCode());
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
		Falta other = (Falta) obj;
		if (idFaltas == null) {
			if (other.idFaltas != null)
				return false;
		} else if (!idFaltas.equals(other.idFaltas))
			return false;
		return true;
	}

}
