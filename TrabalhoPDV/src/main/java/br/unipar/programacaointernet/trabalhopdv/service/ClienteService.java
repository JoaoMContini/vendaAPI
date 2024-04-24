package br.unipar.programacaointernet.trabalhopdv.service;

import br.unipar.programacaointernet.trabalhopdv.dao.ClienteDao;
import br.unipar.programacaointernet.trabalhopdv.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService {
    @Inject
    private ClienteDao clienteDao;

    public List<Cliente> listarClientes(){
        return clienteDao.listarClientes();
    }

    public Cliente listarClienteById(Integer id) throws Exception {
        return clienteDao.listarClienteById(id);
    }

    public void cadastrarCliente(Cliente cliente) throws Exception{
        clienteDao.cadastrarCliente(cliente);
    }

    public void deletarCliente(Cliente cliente)throws Exception{
        clienteDao.deletarCliente(cliente);
    }

    public void atualizarCliente(Cliente cliente) throws Exception{
        clienteDao.atualizarCliente(cliente);
    }
}
