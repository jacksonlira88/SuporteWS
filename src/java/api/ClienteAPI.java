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
import modelo.Cliente;
import modelo.service.ClienteFacadeREST;
import modelo.service.SetorFacadeREST;
import modelo.service.TecnicoFacadeREST;

/**
 *
 * @author jackson
 */
@Path("cliente")
public class ClienteAPI {
    //private static final String SUCCESS_RESULT = "sucess";
    private String tk  = "SUPORTE";
    
    @EJB
    ClienteFacadeREST clienteDAO;
    @EJB
    SetorFacadeREST setor;
    @EJB
    TecnicoFacadeREST tecnico;
    
    @POST
    @Path("novo/{nome}/{idSetor}/{idTecnico}")
    @Produces("application/json")
    @Consumes("application/json")
    public String novo(@PathParam("nome") String nome, 
            @PathParam("idSetor") Integer idSetor,
            @PathParam("idTecnico") Integer idTecnico){
        String senhaAcesso = tk+clienteDAO.countREST();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setSenha(senhaAcesso);
        cliente.setSetoridSetor(setor.find(idSetor));
        cliente.setTecnicoidTecnico(tecnico.find(idTecnico));
        clienteDAO.create(cliente);
        
        return senhaAcesso;
    }
    
    @GET
    @Path("listar")
    @Produces("application/json")
    public List<Cliente> listar(){
        return clienteDAO.findAll();
    }
}
