package br.unipar.programacaointernet.trabalhopdv.controller;

import br.unipar.programacaointernet.trabalhopdv.model.Cliente;
import br.unipar.programacaointernet.trabalhopdv.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClienteController {
    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarClientes(){
        return Response.ok(clienteService.listarClientes()).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listarClienteById(@PathParam("id") Integer id) throws Exception{
        Cliente cliente = clienteService.listarClienteById(id);
        return Response.ok(cliente).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(Cliente cliente){
        try {
            clienteService.cadastrarCliente(cliente);
            return Response.status(201).entity("Cadastrado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarCliente(@PathParam("id") Integer id) throws Exception{
        try {
            Cliente cliente = clienteService.listarClienteById(id);
            clienteService.deletarCliente(cliente);
            return Response.status(201).entity("Detado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarCliente(@PathParam("id") Integer id) {
        try {
            Cliente cliente = clienteService.listarClienteById(id);
            if (cliente == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            clienteService.atualizarCliente(cliente);
            return Response.status(201).entity("Atualizado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

}
