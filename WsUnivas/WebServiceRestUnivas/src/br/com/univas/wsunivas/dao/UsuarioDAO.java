package br.com.univas.wsunivas.dao;

import javax.persistence.EntityManager;

import br.com.univas.wsunivas.dominio.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Long> {
	public UsuarioDAO(EntityManager em) {
		super(em);
	}
}
