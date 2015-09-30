package br.edu.univas.restapiapp.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.univas.restapiapp.model.Aluno;
import br.edu.univas.restapiapp.util.JpaUtil;

public class AlunoEventosCtrl {

	public List<Aluno> getEventosByMatricula(Long idAluno) {
		EntityManager em = JpaUtil.getEntityManager();
		List<Aluno> alunos = em.createQuery(
				"select distinct a from Aluno a inner join fetch a.eventos where a.idDbExterno=:id", 
				Aluno.class).setParameter("id",idAluno)
				.getResultList();
		return alunos;
	}
}
