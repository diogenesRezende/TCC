package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.ProvaAplicada;

public class ProvaAplicadaDAO extends GenericDAO<ProvaAplicada, Long> {
	public ProvaAplicadaDAO(EntityManager em) {
		super(em);
	}
}
