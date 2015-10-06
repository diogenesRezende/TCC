package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.Disciplina;

public class DisciplinaDAO extends GenericDAO<Disciplina, Long> {
	public DisciplinaDAO(EntityManager em) {
		super(em);
	}
}