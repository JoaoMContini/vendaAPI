package br.unipar.programacaointernet.trabalhopdv.controller;

import br.unipar.programacaointernet.trabalhopdv.model.Produto;
import br.unipar.programacaointernet.trabalhopdv.model.Venda;
import br.unipar.programacaointernet.trabalhopdv.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/produto")
public class ProdutoController {
    @Inject
    private ProdutoService produtoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarProdutos(){
        return Response.ok(produtoService.listarProduto()).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listarProdutoById(@PathParam("id") Integer id) throws Exception{
        Produto produto = produtoService.listarProdutoById(id);
        return Response.ok(produto).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarProduto(Produto produto){
        try {
            produtoService.cadastrarProduto(produto);
            return Response.status(201).entity("Cadastrado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarProduto(@PathParam("id") Integer id) throws Exception{
        try {
            Produto produto = produtoService.listarProdutoById(id);
            produtoService.deletarProduto(produto);
            return Response.status(201).entity("Detado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarProduto(@PathParam("id") Integer id) {
        try {
            Produto produto = produtoService.listarProdutoById(id);
            if (produto == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            produtoService.atualizarProduto(produto);
            return Response.status(201).entity("Atualizado com sucesso!!").build();
        }catch (Exception ex){
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
