package br.unipar.programacaointernet.trabalhopdv.controller;

import br.unipar.programacaointernet.trabalhopdv.model.Venda;
import br.unipar.programacaointernet.trabalhopdv.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/venda")
public class VendaController {
    @Inject
    private VendaService vendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarVendas(){
        return Response.ok(vendaService.listarVendas()).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listarVendaById(@PathParam("id") Integer id) throws Exception{
        Venda venda = vendaService.listarVendaById(id);
        return Response.ok(venda).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarVenda(Venda venda){
        try {
            vendaService.cadastrarVenda(venda);
            return Response.status(201).entity("Cadastrado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarVenda(@PathParam("id") Integer id) throws Exception{
        try {
            Venda venda = vendaService.listarVendaById(id);
            vendaService.deletarVenda(venda);
            return Response.status(201).entity("Detado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarVenda(@PathParam("id") Integer id) {
        try {
            Venda venda = vendaService.listarVendaById(id);
            if (venda == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            vendaService.atualizarVenda(venda);
            return Response.status(201).entity("Atualizado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
