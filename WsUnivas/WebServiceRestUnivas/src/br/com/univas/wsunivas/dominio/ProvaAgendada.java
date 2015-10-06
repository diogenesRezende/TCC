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
@Table(name = "provas_agendadas")
public class ProvaAgendada {

	@XmlElement(name = "id")
	private Long idProvaAgendada;
	@XmlElement
	private Date data;
	@XmlElement
	private String descricao;

	private Nota nota;

	/*
	 * ID
	 */
	@Id
	@SequenceGenerator(name = "id_prova_agendada", sequenceName = "seq_id_prova_agendada", allocationSize = 1)
	@GeneratedValue(generator = "id_prova_agendada", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_prova_agendada", nullable = false)
	public Long getIdProvaAgendada() {
		return idProvaAgendada;
	}

	public void setIdProvaAgendada(Long idProvaAgendada) {
		this.idProvaAgendada = idProvaAgendada;
	}

	/*
	 * Relacionamentos
	 */
	@ManyToOne
	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	/*
	 * Campos
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "pag_data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "pap_descricao", length = 100, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*
	 * hashCode e equals
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProvaAgendada == null) ? 0 : idProvaAgendada.hashCode());
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
		ProvaAgendada other = (ProvaAgendada) obj;
		if (idProvaAgendada == null) {
			if (other.idProvaAgendada != null)
				return false;
		} else if (!idProvaAgendada.equals(other.idProvaAgendada))
			return false;
		return true;
	}

}
