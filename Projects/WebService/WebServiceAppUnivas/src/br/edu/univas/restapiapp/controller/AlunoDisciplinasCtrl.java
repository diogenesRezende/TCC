package br.edu.univas.restapiapp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.restapiapp.model.Aluno;
import br.edu.univas.restapiapp.model.Disciplina;
import br.edu.univas.restapiapp.model.Periodo;
import br.edu.univas.restapiapp.util.JpaUtil;

public class AlunoDisciplinasCtrl {

	public Periodo getPeriodoByMatricula(Long idAluno) {
		EntityManager em = JpaUtil.getEntityManager();

		TypedQuery<Periodo> query = em.createQuery(
				"from Periodo p inner join fetch where idDbExterno=:id", Periodo.class)
				.setParameter("id", idAluno);
		Periodo periodo = query.getSingleResult();
		em.close();
		return periodo;
	}

	public Aluno getAlunoByMatricula(Long idAluno) {
		EntityManager em = JpaUtil.getEntityManager();

		TypedQuery<Aluno> query = em.createQuery(
				"from Aluno where idDbExterno=:id", Aluno.class).setParameter(
				"id", idAluno);
		Aluno aluno = query.getSingleResult();
		em.close();
		return aluno;
	}

	public List<Disciplina> getDisciplinaByMtricula(Long idAluno) {
		EntityManager em = JpaUtil.getEntityManager();
		List<Disciplina> alunos = em
				.createQuery(
						"select distinct d from Aluno a left join fetch Periodo p left join fetch Disciplina d where a.idDbExterno=:id",
						Disciplina.class).setParameter("id", idAluno)
				.getResultList();
		em.close();
		return alunos;
	}
}
