package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.ProvaAgendada;

public class ProvaAgendadaDAO extends GenericDAO<ProvaAgendada, Long> {
	public ProvaAgendadaDAO(EntityManager em) {
		super(em);
	}
}
