package br.com.univas.wsunivas.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;

import br.com.univas.wsunivas.dao.AlunoDAO;
import br.com.univas.wsunivas.dominio.Aluno;
import br.com.univas.wsunivas.util.JpaUtil;

@Path("/alunos")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class AlunosService {

	private AlunoDAO dao = new AlunoDAO(JpaUtil.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Aluno alunoByID(@PathParam("id") String id) {

		Long idLong = Long.parseLong(id);

		Aluno aluno = this.dao.obterPeloId(idLong);

		return aluno;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@XmlElement(name = "alunos")
	public List<Aluno> alunoAll() {

		/*
		 * Aluno aluno = this.dao.obterPeloId(2L); this.dao.deletar(aluno);
		 */
		List<Aluno> alunos = new ArrayList<Aluno>(this.dao.obterTodos());

		return alunos;
	}

	@POST
	public Aluno criarAluno(Aluno aluno) {

		this.dao.salvar(aluno);

		return aluno;

	}
}
