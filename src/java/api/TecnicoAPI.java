/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Consumes("application/json")
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
    
            return "Cadastrado, senha de acesso: "+senha;
    }
    
    //implementar método de recuperação de senha
   
    
    // gerar relatório, a definir informações de impressão.
}
