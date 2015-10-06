package br.com.univas.wsunivas.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.univas.wsunivas.dao.FaltaDAO;
import br.com.univas.wsunivas.dominio.Falta;
import br.com.univas.wsunivas.util.JpaUtil;

@Path("/faltas")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class FaltasService {

	private FaltaDAO dao = new FaltaDAO(JpaUtil.getEntityManager());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Falta faltasById(@PathParam("id") String id) {
		Long idLong = Long.parseLong(id);
		Falta faltas = this.dao.obterPeloId(idLong);
		return faltas;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Falta> falta() {
		return this.dao.obterTodos();
	}
	@POST
	public Falta lancaFalta(Falta falta){
		this.dao.salvar(falta);
		return falta;
	}
}
