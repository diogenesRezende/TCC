package br.com.univas.wsunivas.dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.univas.wsunivas.util.JpaUtil;

public class CriaTables {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("WsUnivas");

		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		for (int i = 0; i <= 10; i++) {

			tx.begin();
			Usuario user = new Usuario();
			user.setPassword("Abc123" + i);
			user.setUsername("Djorge" + i);

			manager.persist(user);

			tx.commit();
		}

		manager.clear();
		JpaUtil.close();

	}

}
