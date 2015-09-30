package br.edu.univas.restapiapp.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.univas.restapiapp.controller.AlunoDisciplinasCtrl;
import br.edu.univas.restapiapp.controller.AlunoEventosCtrl;
import br.edu.univas.restapiapp.entities.AlunoDisciplinas;
import br.edu.univas.restapiapp.entities.AlunoEventos;

@Path("/alunos")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AlunosService {

	@GET
	// @Path("/{idCloud}")
	@Path("/eventos/{id}")
	public AlunoEventos getEventosByIdAluno(@PathParam("id") String id) {

		System.out.println("id aluno " + id);

		Long idAluno = Long.parseLong(id);

		AlunoEventos alunos = new AlunoEventos();
		AlunoEventosCtrl ctrl = new AlunoEventosCtrl();
		alunos.setAluno(ctrl.getEventosByMatricula(idAluno));

		return alunos;
	}

	@GET
	// @Path("/{idCloud}")
	@Path("/disciplinas/{id}")
	public AlunoDisciplinas getDisciplinasByIdAluno(@PathParam("id") String id) {

		System.out.println("id aluno " + id);

		Long idAluno = Long.parseLong(id);

		AlunoDisciplinas aluno = new AlunoDisciplinas();
		AlunoDisciplinasCtrl ctrl = new AlunoDisciplinasCtrl();

		aluno.setAluno(ctrl.getAlunoByMatricula(idAluno));
		aluno.setPeriodo(ctrl.getPeriodoByMatricula(idAluno));
//		aluno.setDisciplinas(ctrl.getDisciplinaByMtricula(idAluno));

		return aluno;
	}
}
