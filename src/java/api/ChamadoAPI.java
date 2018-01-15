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
import modelo.Chamado;
import modelo.Cliente;
import modelo.service.ChamadoFacadeREST;
import modelo.service.ClienteFacadeREST;
import modelo.service.TecnicoFacadeREST;
/**
 *
 * @author jackson
 */
@Path("chamado")
public class ChamadoAPI {
    @EJB
    ChamadoFacadeREST chamadoDAO;
    @EJB
    TecnicoFacadeREST tecnicoDAO;
    @EJB
    ClienteFacadeREST clienteDAO;
    
    @POST
    @Path("novo/{nome}/{descricao}/{idCliente}/{idTecnico}/{token}")
    @Consumes("application/json")
    @Produces("application/json")
    public String novo(@PathParam("nome") String nome, 
            @PathParam("descricao") String descricao, 
            @PathParam("idCliente") Integer idCliente,
            @PathParam("idTecnico") Integer idTecnico,
            @PathParam("token") String token){
        
        //boolean aut = autentica(idCliente,token); 
        if(autentica(idCliente,token)){
            Chamado chamado = new Chamado();
            chamado.setNomeProblema(nome);
            chamado.setDescricaoProblema(descricao);
            chamado.setTecnicoidTecnico(tecnicoDAO.find(idTecnico));
            chamado.setClienteidCliente(clienteDAO.find(idCliente));
            
            return "salvo";
        }else{
            
            return "Usuário não altorizado!";
        }
    }
    
    // lista todo os chamados
    @GET
    @Path("listar")
    @Produces("application/json")
    public List<Chamado> listar(){
        return chamadoDAO.findAll();
    }
    //lista chamados abertos pelo id do usuário
    
    
    // listar chamados resolvidos 
    
    ///implementar uma forma de avaliação.
    public void avaliar(){
        
    }
    
    // métodos auxiliares
    private boolean autentica(Integer idCliente, String token){
        boolean aut = false;
        Cliente c;
        try{
        c = clienteDAO.find(idCliente);
        if(!c.getSenha().isEmpty()){
            if(c.getSenha().equals(token)){
                aut = true;
            }
        }
        }catch(NullPointerException e){
        }
        return aut;
    }
    
    
}
