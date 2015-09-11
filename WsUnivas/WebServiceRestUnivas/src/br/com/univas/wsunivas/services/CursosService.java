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
import br.com.univas.wsunivas.dominio.Curso;
import br.com.univas.wsunivas.repository.AlunosRepositorie;
import br.com.univas.wsunivas.repository.CursosRepositorie;

@Path("/cursos")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class CursosService {

	private CursosRepositorie repo = new CursosRepositorie();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Curso cursoByID(@PathParam("id") String id) {

		Long idLong = Long.parseLong(id);

		Curso cursos = this.repo.buscaCursoPeloId(idLong);

		return cursos;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Curso> cursosAll() {
		return this.repo.getAllCursos();
	}

	@POST
	public Curso criarCuro(Curso curso) {

		if (this.repo.inserirCurso(curso)) {
			System.out.println(curso.toString());
		}
		return curso;

	}

}
