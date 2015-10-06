package br.com.univas.wsunivas.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "faltas")
public class Falta {
	@XmlElement(name = "id")
	private Long idFaltas;
	@XmlElement
	private Date data;

	private Disciplina disciplina;

	/*
	 * ID
	 */
	@Id
	@SequenceGenerator(name = "id_falta", sequenceName = "seq_id_falta", allocationSize = 1)
	@GeneratedValue(generator = "id_falta", strategy = GenerationType.SEQUENCE)
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
