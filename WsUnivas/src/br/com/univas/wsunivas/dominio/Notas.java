package br.com.univas.wsunivas.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notas {
	private Long idNotas;
	private float valor;

	@Id
	@GeneratedValue
	@Column(name = "id_notas")
	public Long getIdNotas() {
		return idNotas;
	}

	public void setIdNotas(Long idNotas) {
		this.idNotas = idNotas;
	}

	@Column(precision = 10, scale = 2, nullable = true)
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNotas == null) ? 0 : idNotas.hashCode());
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
		Notas other = (Notas) obj;
		if (idNotas == null) {
			if (other.idNotas != null)
				return false;
		} else if (!idNotas.equals(other.idNotas))
			return false;
		return true;
	}

}
