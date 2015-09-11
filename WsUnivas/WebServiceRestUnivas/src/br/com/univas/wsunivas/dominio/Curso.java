package br.com.univas.wsunivas.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "cursos")
public class Curso {

	@XmlElement(name = "id")
	private Long idCurso;
	private String nome;
	private String descricao;

	private List<Aluno> alunos;

	/*
	 * ID
	 */

	@Id
	@SequenceGenerator(name = "id_curso", sequenceName = "seq_id_curso", allocationSize = 1)
	@GeneratedValue(generator = "id_curso", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_curso", nullable = false)
	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	/*
	 * Relacionamentos
	 */
	@OneToMany(mappedBy = "curso")
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	/*
	 * Outros campos da tabela
	 */
	@Column(name = "cur_nome", length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "cur_descricao", length = 100, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*
	 * HashCode e Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		return true;
	}

}
