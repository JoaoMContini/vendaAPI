package br.unipar.programacaointernet.trabalhopdv.service;

import br.unipar.programacaointernet.trabalhopdv.dao.ProdutoDao;
import br.unipar.programacaointernet.trabalhopdv.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ProdutoService {
    @Inject
    private ProdutoDao produtoDao;

    public List<Produto> listarProduto(){
        return produtoDao.listarProdutos();
    }

    public Produto listarProdutoById(Integer id) throws Exception {
        return produtoDao.listarProdutoById(id);
    }

    public void cadastrarProduto(Produto produto) throws Exception{
        produtoDao.cadastrarProduto(produto);
    }

    public void deletarProduto(Produto produto)throws Exception{
        produtoDao.deletarProduto(produto);
    }

    public void atualizarProduto(Produto produto) throws Exception{
        produtoDao.atualizarProduto(produto);
    }
}
