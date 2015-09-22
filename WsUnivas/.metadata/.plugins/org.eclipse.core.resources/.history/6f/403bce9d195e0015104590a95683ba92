package br.edu.univas.restapiapp.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.edu.univas.restapiapp.util.JpaUtil;

public class CreateTable {

	public static void main(String[] args) {
//		

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
