package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.univas.wsunivas.util.JpaUtil;

public class CreateTable {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("WsUnivas");

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		/**
		 * tx.begin();
		 * 
		 * Curso curso = new Curso();
		 * 
		 * curso.setDescricao("Sistemas de informação");
		 * curso.setNome("Sistemas de informação");
		 * 
		 * manager.persist(curso);
		 * 
		 * tx.commit();
		 */
		manager.clear();
		JpaUtil.close();

	}

}
