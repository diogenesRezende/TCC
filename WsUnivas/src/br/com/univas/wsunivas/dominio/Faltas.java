package br.com.univas.wsunivas.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "faltas")
public class Faltas {

	private Long idFaltas;
	private Date data;

	@Id
	@GeneratedValue
	@Column(name = "id_faltas")
	public Long getIdFaltas() {
		return idFaltas;
	}

	public void setIdFaltas(Long idFaltas) {
		this.idFaltas = idFaltas;
	}

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		Faltas other = (Faltas) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
