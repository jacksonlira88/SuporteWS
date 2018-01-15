/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tecnico;

/**
 *
 * @author jackson
 */
@Stateless
public class TecnicoFacadeREST extends AbstractFacade<Tecnico> {
    @PersistenceContext(unitName = "SuporteWSPU")
    private EntityManager em;

    public TecnicoFacadeREST() {
        super(Tecnico.class);
    }

    @Override
    public void create(Tecnico entity) {
        super.create(entity);
    }

    public void edit(Integer id, Tecnico entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public Tecnico find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<Tecnico> findAll() {
        return super.findAll();
    }

    public List<Tecnico> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
