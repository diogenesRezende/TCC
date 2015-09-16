package br.edu.univas.restapiapp.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.univas.restapiapp.controller.AlunoCtrl;
import br.edu.univas.restapiapp.entities.Alunos;

@Path("/alunos")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AlunosService {

	@GET
	public Alunos getAllEventoS() {

		Alunos alunos = new Alunos();
		AlunoCtrl ctrl = new AlunoCtrl();
		alunos.setAlunos(ctrl.getAll());

		return alunos;
	}
}
