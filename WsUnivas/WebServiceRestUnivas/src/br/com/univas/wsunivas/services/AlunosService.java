package br.com.univas.wsunivas.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.univas.wsunivas.dominio.Aluno;
import br.com.univas.wsunivas.repository.AlunosRepositorie;

@Path("/alunos")
@Consumes({MediaType.APPLICATION_JSON })
@Produces({MediaType.APPLICATION_JSON})
public class AlunosService {

	private AlunosRepositorie repo = new AlunosRepositorie();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aluno alunoByID(@PathParam("id") String id) {

		Long idLong = Long.parseLong(id);

		Aluno aluno = this.repo.buscaAlunoPeloId(idLong);

		return aluno;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aluno> alunoAll() {
		return this.repo.getAllAlunos();
	}

	@POST
	public Aluno criarAluno(Aluno aluno) {

		if (this.repo.inserirAluno(aluno)) {
			System.out.println(aluno.toString());
		}
		return aluno;

	}
}
