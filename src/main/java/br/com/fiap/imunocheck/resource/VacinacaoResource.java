package br.com.fiap.imunocheck.resource;

import java.util.ArrayList;

import br.com.fiap.imunocheck.model.bean.DadosUsuario;
import br.com.fiap.imunocheck.model.bean.Vacinas;
import br.com.fiap.imunocheck.model.repository.VacinacaoRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/imunocheck")
public class VacinacaoResource {
	/***
	 * Método para encontrar todos os clientes através do GET
	 * @author luizfillipe
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<DadosUsuario> resposta = VacinacaoRepository.findAll();
		  if (resposta != null && !resposta.isEmpty()) {
	            System.out.println("Usuários encontrados");
	            ResponseBuilder response = Response.ok(resposta, MediaType.APPLICATION_JSON);
	           
	            return response.build();
	        } else {
	        	System.out.println("Nenhum usuário encontrado");
	            ResponseBuilder response = Response.status(404);
	            return response.build();
	        }
	}
		  
	@GET
	@Path("/{usuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findOne(@PathParam("usuario") String usuario) {
		ArrayList<DadosUsuario> resposta = VacinacaoRepository.findOne(usuario);
		  if (resposta != null && !resposta.isEmpty()) {
	            System.out.println("Usuário encontrado");
	            ResponseBuilder response = Response.ok(resposta, MediaType.APPLICATION_JSON);
	           
	            return response.build();
	        } else {
	        	System.out.println("Usuário não encontrado");
			            ResponseBuilder response = Response.status(404);
			            return response.build();
			        }	
		
}
	/***
	 * Método para adicionar os dados necessários para a vistoria utilizando POST
	 * @author luizfillipe
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid DadosUsuario dado) {
		DadosUsuario resposta = VacinacaoRepository.save(dado);
		ResponseBuilder response = null;
		if(resposta != null) {
			response = Response.created(null);
		}
		else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	
	@DELETE
	@Path("/{usuario}")
	public Response delete(@PathParam("usuario") String usuario) {
		if (VacinacaoRepository.delete(usuario)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404);
			return response.build();
		}
	}
	
	
// Caderneta de vacinas

	@GET
	@Path("/vacinas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllVac() {
		ArrayList<Vacinas> resposta = VacinacaoRepository.findAllVac();
		  if (resposta != null && !resposta.isEmpty()) {
	            System.out.println("Usuários encontrados");
	            ResponseBuilder response = Response.ok(resposta, MediaType.APPLICATION_JSON);
	           
	            return response.build();
	        } else {
	        	System.out.println("Nenhum usuário encontrado");
	            ResponseBuilder response = Response.status(404);
	            return response.build();
	        }
	}
	
	@GET
	@Path("/vacinas/{usuarioVac}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findVac(@PathParam("usuarioVac") String usuario) {
		ArrayList<Vacinas> resposta = VacinacaoRepository.findVac(usuario);
		  if (resposta != null && !resposta.isEmpty()) {
	            System.out.println("Vacinas encontradas");
	            ResponseBuilder response = Response.ok(resposta, MediaType.APPLICATION_JSON);
	            return response.build();
	        } else {
	        	System.out.println("Vacinas não encontradas");
			            ResponseBuilder response = Response.status(404);
			            return response.build();
			        }	
}
	@POST
	@Path("/vacinas")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveVac(@Valid Vacinas vacinas) {
		Vacinas resposta = VacinacaoRepository.saveVac(vacinas);
		ResponseBuilder response = null;
		if(resposta != null) {
			response = Response.created(null);
		}
		else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	
	@PUT
	@Path("/vacinas")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateVac(@Valid Vacinas vacinas) {
		Vacinas resposta = VacinacaoRepository.updateVac(vacinas);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(response);
		return response.build();
	}
	
	@DELETE
	@Path("/vacinas/{usuarioVac}")
	public Response deleteVac(@PathParam("usuarioVac") String usuario) {
		if (VacinacaoRepository.deleteVac(usuario)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404);
			return response.build();
		}
	}
	

	
}