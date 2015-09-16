package br.edu.univas.restapiapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "alunos")
public class Aluno {
	@XmlElement(name = "id")
	private Long idAluno;
	@XmlElement(name = "id_externo")
	private Long idDbExterno;
	@XmlElement
	private String nome;
	@XmlElement
	private Integer periodo;
	@XmlElement
	private String email;
	@XmlTransient
	private List<Evento> eventos;

	/*
	 * ID
	 */
	@Id
	@SequenceGenerator(name = "id_aluno", sequenceName = "seq_id_aluno", allocationSize = 1)
	@GeneratedValue(generator = "id_aluno", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_aluno", nullable = false)
	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	/*
	 * Relacionamentos
	 */
	@OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER)
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

	@Column(nullable = false)
	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	@Column(length = 100, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * hashCode e equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
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
		Aluno other = (Aluno) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		return true;
	}

}
