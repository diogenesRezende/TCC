package br.com.univas.wsunivas.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.univas.wsunivas.dao.DisciplinaDAO;
import br.com.univas.wsunivas.dominio.Disciplina;
import br.com.univas.wsunivas.util.JpaUtil;

@Path("/disciplinas")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class DisciplinasService {

	private DisciplinaDAO dao = new DisciplinaDAO(JpaUtil.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Disciplina disciplinaByID(@PathParam("id") String id) {
		/*
		 * o id é recebido como uma string e no banco está como Long então é
		 * necessário fazer o parse
		 */
		Long idLong = Long.parseLong(id);

		/*
		 * busca uma disciplina pelo id
		 */
		Disciplina disciplina = this.dao.obterPeloId(idLong);

		return disciplina;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disciplina> disciplinasAll() {
		return this.dao.obterTodos();
	}
	
	@POST
	public Disciplina criaDisciplina(Disciplina disciplina){
		this.dao.salvar(disciplina);
		return disciplina;
	}
}
