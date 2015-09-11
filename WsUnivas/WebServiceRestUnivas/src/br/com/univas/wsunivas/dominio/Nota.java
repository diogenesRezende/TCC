package br.com.univas.wsunivas.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "notas")
public class Nota {

	private Long idNota;
	private Float valor;

	private Disciplina disciplina;
	private List<ProvaAgendada> provasAgendadas;
	private List<ProvaAplicada> provasAplicadas;

	/*
	 * ID
	 */
	@Id
	@GeneratedValue
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
