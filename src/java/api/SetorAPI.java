/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import modelo.Setor;
import modelo.service.SetorFacadeREST;

/**
 *
 * @author jackson
 */
@Path("setor")
public class SetorAPI {
    
    @EJB
    SetorFacadeREST setorDAO;
    
    @POST
    @Path("novo/{nome}/{prioridade}")
    @Consumes("application/json")
    public void novo(@PathParam("nome") String nome, 
            @PathParam("prioridade") int prioridade){
        Setor setor = new Setor();
        setor.setNome(nome);
        setor.setPrioridade(prioridade);
        setorDAO.create(setor);
    }
    
    @GET
    @Path("listar")
    @Produces("application/json")
    public List<Setor> listar(){
        return setorDAO.findAll();
    }
    
}
