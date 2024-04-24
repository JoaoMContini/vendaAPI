package br.unipar.programacaointernet.trabalhopdv.service;

import br.unipar.programacaointernet.trabalhopdv.dao.VendaDao;
import br.unipar.programacaointernet.trabalhopdv.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class VendaService {
    @Inject
    private VendaDao vendaDao;

    public List<Venda> listarVendas(){
        return vendaDao.listarVendas();
    }

    public Venda listarVendaById(Integer id) throws Exception {
        return vendaDao.listarVendaById(id);
    }

    public void cadastrarVenda(Venda venda) throws Exception{
        vendaDao.cadastrarVenda(venda);
    }

    public void deletarVenda(Venda venda)throws Exception{
        vendaDao.deletarVenda(venda);
    }

    public void atualizarVenda(Venda venda) throws Exception{
        vendaDao.atualizarVenda(venda);
    }
}
