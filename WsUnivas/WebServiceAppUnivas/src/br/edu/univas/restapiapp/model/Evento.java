package br.edu.univas.restapiapp.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "eventos")
public class Evento {
	@XmlElement(name = "id")
	private Long idEvento;
	@XmlElement
	private Date dataLancamento;
	@XmlElement
	private Date dataEfetiva;
	@XmlElement
	private String tipo;
	@XmlElement
	private BigDecimal nota;
	@XmlElement
	private TipoEvento tipoEvento;

	private Aluno aluno;
	private Disciplina disciplina;


	/*
	 * ID
	 */
	@Id
	@SequenceGenerator(name = "id_evento", sequenceName = "seq_id_evento", allocationSize = 1)
	@GeneratedValue(generator = "id_evento", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_evento", nullable = false)
	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	/*
	 * Relacionamentos
	 */
	@ManyToOne
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@ManyToOne
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	/*
	 * Outros campos da tabela
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "data_lancamento", nullable = false)
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_efetiva", nullable = false)
	public Date getDataEfetiva() {
		return dataEfetiva;
	}

	public void setDataEfetiva(Date dataEfetiva) {
		this.dataEfetiva = dataEfetiva;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	@Column(name = "tipo_evento", nullable = false)
	@Enumerated(EnumType.STRING)
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	/*
	 * hashCode e equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idEvento == null) ? 0 : idEvento.hashCode());
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
		Evento other = (Evento) obj;
		if (idEvento == null) {
			if (other.idEvento != null)
				return false;
		} else if (!idEvento.equals(other.idEvento))
			return false;
		return true;
	}
}
