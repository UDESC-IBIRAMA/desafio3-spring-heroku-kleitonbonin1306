/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Veiculo;

/**
 *
 * @author Kleiton Bonin
 */
@Stateless
@Path("veiculo")
public class VeiculoFacadeREST extends AbstractFacade<Veiculo> {

    @PersistenceContext(unitName = "com.mycompany_Desafio3KleitonBonin_1.0-SNAPSHOTPU")
    private EntityManager em;

    public VeiculoFacadeREST() {
        super(Veiculo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Veiculo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Veiculo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public Veiculo find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Path("/montadora/{montadora_nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findMontadoraNome(@PathParam("montadora_nome") String montadora_nome) {
        return super.findMontadoraNome(montadora_nome);
    }
      @GET
    @Path("/modelo/{modelo_nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findModeloNome(@PathParam("modelo_nome") String modelo_nome) {
        return super.findModeloNome(modelo_nome);
    }
    
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces( MediaType.APPLICATION_JSON)
    public List<Veiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
