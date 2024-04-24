package br.unipar.programacaointernet.trabalhopdv.dao;

import br.unipar.programacaointernet.trabalhopdv.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class ProdutoDao {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Produto> listarProdutos(){
        String jpql = ("SELECT p FROM Produto p");
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public Produto listarProdutoById(Integer id) throws Exception{
        try {
            String jpql = "SELECT p FROM Produto p WHERE p.id = :id";
            return em.createQuery(jpql, Produto.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Não foi encontrado nenhum produto para esse id");
        }
    }

    public void cadastrarProduto(Produto produto) throws Exception {
        try {
            em.persist(produto);
        } catch (Exception ex) {
            throw new Exception("O Produto não pode ser criado");
        }
    }

    public void deletarProduto(Produto produto) throws Exception {
        try {
            em.remove(produto);
        } catch (Exception ex) {
            throw new Exception("O Produto não pode ser deletado");
        }
    }

    public void atualizarProduto(Produto produto) throws Exception {
        try {
            em.merge(produto);
        } catch (Exception ex) {
            throw new Exception("O Produto não pode ser atualizado");
        }
    }
}
