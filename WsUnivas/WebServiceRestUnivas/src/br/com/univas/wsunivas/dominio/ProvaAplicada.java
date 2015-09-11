package br.com.univas.wsunivas.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "provas_aplicadas")
public class ProvaAplicada {

	private Long idProvaAplicada;
	private Date data;
	private String descricao;

	private Nota nota;

	/*
	 * ID
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_prova_aplicada")
	public Long getIdProvaAplicada() {
		return idProvaAplicada;
	}

	public void setIdProvaAplicada(Long idProvaAplicada) {
		this.idProvaAplicada = idProvaAplicada;
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
	@Column(name = "pap_data", nullable = false)
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
	 * hashCode e equal
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProvaAplicada == null) ? 0 : idProvaAplicada.hashCode());
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
		ProvaAplicada other = (ProvaAplicada) obj;
		if (idProvaAplicada == null) {
			if (other.idProvaAplicada != null)
				return false;
		} else if (!idProvaAplicada.equals(other.idProvaAplicada))
			return false;
		return true;
	}

}
