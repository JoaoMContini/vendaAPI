package br.unipar.programacaointernet.trabalhopdv.dao;

import br.unipar.programacaointernet.trabalhopdv.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;
@Stateless
public class VendaDao {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Venda> listarVendas(){
        String jpql = ("SELECT v FROM Venda v");
        return em.createQuery(jpql, Venda.class).getResultList();
    }

    public Venda listarVendaById(Integer id) throws Exception{
        try {
            String jpql = "SELECT v FROM Venda v WHERE v.id = :id";
            return em.createQuery(jpql, Venda.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Não foi encontrada nenhuma venda para esse id");
        }
    }

    public void cadastrarVenda(Venda venda) throws Exception {
        try {
            em.persist(venda);
        } catch (Exception ex) {
            throw new Exception("A venda não pode ser criado");
        }
    }

    public void deletarVenda(Venda venda) throws Exception {
        try {
            em.remove(venda);
        } catch (Exception ex) {
            throw new Exception("A venda não pode ser deletado");
        }
    }

    public void atualizarVenda(Venda venda) throws Exception {
        try {
            em.merge(venda);
        } catch (Exception ex) {
            throw new Exception("A venda não pode ser atualizado");
        }
    }
}
