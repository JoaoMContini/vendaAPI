package br.unipar.programacaointernet.trabalhopdv.controller;

import br.unipar.programacaointernet.trabalhopdv.model.Itens_Venda;
import br.unipar.programacaointernet.trabalhopdv.service.Itens_VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/item")
public class Itens_VendaController {
    @Inject
    private Itens_VendaService itensVendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarItensVenda(){
        return Response.ok(itensVendaService.listarItensVendas()).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listarItensVendaById(@PathParam("id") Integer id) throws Exception{
        Itens_Venda itensVenda = itensVendaService.listarItensVendaById(id);
        return Response.ok(itensVenda).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarItensVenda(Itens_Venda itensVenda){
        try {
            itensVendaService.cadastrarItensVenda(itensVenda);
            return Response.status(201).entity("Cadastrado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarItensVenda(@PathParam("id") Integer id) throws Exception{
        try {
            Itens_Venda itensVenda = itensVendaService.listarItensVendaById(id);
            itensVendaService.deletarItensVenda(itensVenda);
            return Response.status(201).entity("Detado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarItensVenda(@PathParam("id") Integer id) {
        try {
            Itens_Venda itensVenda = itensVendaService.listarItensVendaById(id);
            if (itensVenda == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            itensVendaService.atualizarItensVenda(itensVenda);
            return Response.status(201).entity("Atualizado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
