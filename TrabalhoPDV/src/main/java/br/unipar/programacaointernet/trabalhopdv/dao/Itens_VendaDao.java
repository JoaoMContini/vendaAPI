package br.unipar.programacaointernet.trabalhopdv.dao;

import br.unipar.programacaointernet.trabalhopdv.model.Itens_Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class Itens_VendaDao {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Itens_Venda> listarItensVenda(){
        String jpql = ("SELECT iv FROM Itens_Venda iv");
        return em.createQuery(jpql, Itens_Venda.class).getResultList();
    }

    public Itens_Venda listarItensVendaById(Integer id) throws Exception{
        try {
            String jpql = "SELECT iv FROM Itens_Venda iv WHERE iv.id = :id";
            return em.createQuery(jpql, Itens_Venda.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Não foi encontrado nenhum Itens_Venda para esse id");
        }
    }

    public void cadastrarItensVenda(Itens_Venda itensVenda) throws Exception {
        try {
            em.persist(itensVenda);
        } catch (Exception ex) {
            throw new Exception("O Itens_Venda não pode ser criado");
        }
    }

    public void deletarItensVenda(Itens_Venda itensVenda) throws Exception {
        try {
            em.remove(itensVenda);
        } catch (Exception ex) {
            throw new Exception("O Itens_Venda não pode ser deletado");
        }
    }

    public void atualizarItensVenda(Itens_Venda itensVenda) throws Exception {
        try {
            em.merge(itensVenda);
        } catch (Exception ex) {
            throw new Exception("O Itens_Venda não pode ser atualizado");
        }
    }
}
