package br.com.univas.wsunivas.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "notas")
public class Nota {

	@XmlElement(name = "id")
	private Long idNota;
	@XmlElement
	private Float valor;

	private Disciplina disciplina;
	private List<ProvaAgendada> provasAgendadas;
	private List<ProvaAplicada> provasAplicadas;

	/*
	 * ID
	 */
	@Id
	@SequenceGenerator(name = "id_nota", sequenceName = "seq_id_nota", allocationSize = 1)
	@GeneratedValue(generator = "id_nota", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_nota", nullable = false)
	public Long getIdNota() {
		return idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
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

	@OneToMany(mappedBy = "nota")
	public List<ProvaAgendada> getProvasAgendadas() {
		return provasAgendadas;
	}

	public void setProvasAgendadas(List<ProvaAgendada> provasAgendadas) {
		this.provasAgendadas = provasAgendadas;
	}

	@OneToMany(mappedBy = "nota")
	public List<ProvaAplicada> getProvasAplicadas() {
		return provasAplicadas;
	}

	public void setProvasAplicadas(List<ProvaAplicada> provasAplicadas) {
		this.provasAplicadas = provasAplicadas;
	}

	/*
	 * Campos
	 */

	@Column(name = "not_valor")
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	/*
	 * hashCode e equals
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNota == null) ? 0 : idNota.hashCode());
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
		Nota other = (Nota) obj;
		if (idNota == null) {
			if (other.idNota != null)
				return false;
		} else if (!idNota.equals(other.idNota))
			return false;
		return true;
	}

}
