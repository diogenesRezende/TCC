package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.Matricula;

public class MatriculaDAO extends GenericDAO<Matricula, Long> {
	public MatriculaDAO(EntityManager em) {
		super(em);
	}
}
