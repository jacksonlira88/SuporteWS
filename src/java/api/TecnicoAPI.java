/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import modelo.Tecnico;
import modelo.service.TecnicoFacadeREST;

/**
 *
 * @author jackson
 */
@Path("tecnico")
public class TecnicoAPI {
    
    @EJB
    TecnicoFacadeREST tecnicoDAO;
    
    @POST
    @Path("novo/{nome}/{empresa}/{funcao}")
    @Produces("application/json")
    public String novo(@PathParam("nome") String nome, 
            @PathParam("empresa") String empresa, 
            @PathParam("funcao") String funcao){
            int senha = 2017+tecnicoDAO.count();
            Tecnico tecnico = new Tecnico();
            tecnico.setNome(nome);
            tecnico.setEmpresa(empresa);
            tecnico.setFuncao(funcao);
            tecnico.setSenha(senha);
            //tecnico.setMatricula(matricula);
            tecnicoDAO.create(tecnico);
            
            return new Gson().toJson(tecnico);
    }
    
    @GET
    @Path("teste")
    public String teste(){
        return "Web Service online!!";
    }
    //implementar método de recuperação de senha
   
    
    // gerar relatório, a definir informações de impressão.
}
