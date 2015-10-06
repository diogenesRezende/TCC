package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.Falta;

public class FaltaDAO extends GenericDAO<Falta, Long> {
	public FaltaDAO(EntityManager em) {
		super(em);
	}
}
