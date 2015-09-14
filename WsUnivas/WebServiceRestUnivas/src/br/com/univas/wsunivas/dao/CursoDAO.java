package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.Curso;

public class CursoDAO extends GenericDAO<Curso, Long> {
	public CursoDAO(EntityManager em) {
		super(em);
	}
}
