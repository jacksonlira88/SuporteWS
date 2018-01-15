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
import modelo.Setor;

/**
 *
 * @author jackson
 */
@Stateless
public class SetorFacadeREST extends AbstractFacade<Setor> {
    @PersistenceContext(unitName = "SuporteWSPU")
    private EntityManager em;

    public SetorFacadeREST() {
        super(Setor.class);
    }

    @Override
    public void create(Setor entity) {
        super.create(entity);
    }

    public void edit(Integer id, Setor entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public Setor find(Integer id) {
        return super.find(id);
    }

    @Override
    public List<Setor> findAll() {
        return super.findAll();
    }

    public List<Setor> findRange(Integer from, Integer to) {
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
