package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.Aluno;

public class AlunoDAO extends GenericDAO<Aluno, Long> {
	public AlunoDAO(EntityManager em) {
		super(em);
	}
}
