package br.unipar.programacaointernet.trabalhopdv.dao;

import br.unipar.programacaointernet.trabalhopdv.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ClienteDao {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Cliente> listarClientes(){
    String jpql = ("SELECT c FROM Cliente c");
    return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente listarClienteById(Integer id) throws Exception{
        try {
            String jpql = "SELECT c FROM Cliente c WHERE c.id = :id";
            return em.createQuery(jpql, Cliente.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Não foi encontrado nenhum cliente para esse id");
        }
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {
        try {
            em.persist(cliente);
        } catch (Exception ex) {
            throw new Exception("O Cliente não pode ser criado");
        }
    }

    public void deletarCliente(Cliente cliente) throws Exception {
        try {
            em.remove(cliente);
        } catch (Exception ex) {
            throw new Exception("O Cliente não pode ser deletado");
        }
    }

    public void atualizarCliente(Cliente cliente) throws Exception {
        try {
            em.merge(cliente);
        } catch (Exception ex) {
            throw new Exception("O Cliente não pode ser atualizado");
        }
    }
}
