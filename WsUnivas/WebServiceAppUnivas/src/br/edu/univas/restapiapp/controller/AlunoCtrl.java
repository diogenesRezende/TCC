package br.edu.univas.restapiapp.controller;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.univas.restapiapp.model.Aluno;
import br.edu.univas.restapiapp.util.JpaUtil;

public class AlunoCtrl {

	public List<Aluno> getAll() {
		EntityManager em = JpaUtil.getEntityManager();
		List<Aluno> alunos = em.createQuery("from Aluno", Aluno.class)
				.getResultList();
		return alunos;
	}
}
