package br.com.univas.wsunivas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.univas.wsunivas.dominio.Aluno;
import br.com.univas.wsunivas.dominio.Curso;
import br.com.univas.wsunivas.util.JpaUtil;

public class CursosRepositorie {

	private static List<Curso> cursos;

	public static List<Curso> getCursos() {
		return cursos;
	}

	public static void setCursos(List<Curso> cursos) {
		CursosRepositorie.cursos = cursos;
	}

	public Curso buscaCursoPeloId(Long idLong) {
		EntityManager manager = JpaUtil.getEntityManager();

		Curso curso = manager.find(Curso.class, idLong);

		return curso;
	}

	public List<Curso> getAllCursos() {
		EntityManager manager = JpaUtil.getEntityManager();

		Query query = manager.createQuery("from Curso ");
		List<Curso> resultList = query.getResultList();
		this.setCursos(resultList);
		return this.getCursos();

	}

	public boolean inserirCurso(Curso curso) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(curso);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		}

	}

}
