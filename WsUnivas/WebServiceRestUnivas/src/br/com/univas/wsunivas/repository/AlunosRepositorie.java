package br.com.univas.wsunivas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.univas.wsunivas.dominio.Aluno;
import br.com.univas.wsunivas.util.JpaUtil;

public class AlunosRepositorie {

	private static List<Aluno> alunos;

	public AlunosRepositorie() {

	}

	public Aluno buscaAlunoPeloId(Long id) {
		EntityManager manager = JpaUtil.getEntityManager();

		Aluno aluno = manager.find(Aluno.class, id);

		return aluno;
	}

	public boolean inserirAluno(Aluno aluno) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(aluno);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		}

	}

	public List<Aluno> getAllAlunos() {
		EntityManager manager = JpaUtil.getEntityManager();

		Query query = manager.createQuery("from Aluno ");
		List<Aluno> resultList = query.getResultList();
		this.setAlunos(resultList);
		return this.getAlunos();

	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
