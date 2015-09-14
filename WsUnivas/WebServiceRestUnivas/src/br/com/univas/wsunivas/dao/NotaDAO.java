package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.Nota;

public class NotaDAO extends GenericDAO<Nota, Long> {
	public NotaDAO(EntityManager em) {
		super(em);
	}
}
