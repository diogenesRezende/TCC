package br.edu.univas.restapiapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "disciplinas")
public class Disciplina {
	@XmlElement(name = "id")
	private Long idDisciplina;
	@XmlElement
	private Long idDbExterno;
	@XmlElement
	private String nome;
	@XmlElement
	private String descricao;

	private List<Evento> eventos;

	/*
	 * ID
	 */
	@Id
	@SequenceGenerator(name = "id_disciplina", sequenceName = "seq_id_disciplina", allocationSize = 1)
	@GeneratedValue(generator = "id_disciplina", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_disciplina", nullable = false)
	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	/*
	 * Relacionamentos
	 */
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.EAGER)
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	/*
	 * Outros campos da tabela
	 */
	@Column(name = "id_externo", nullable = false)
	public Long getIdDbExterno() {
		return idDbExterno;
	}

	public void setIdDbExterno(Long idDbExterno) {
		this.idDbExterno = idDbExterno;
	}

	@Column(length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 100)
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
				+ ((idDisciplina == null) ? 0 : idDisciplina.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (idDisciplina == null) {
			if (other.idDisciplina != null)
				return false;
		} else if (!idDisciplina.equals(other.idDisciplina))
			return false;
		return true;
	}

}
