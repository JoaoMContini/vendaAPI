package br.unipar.programacaointernet.trabalhopdv.service;

import br.unipar.programacaointernet.trabalhopdv.dao.Itens_VendaDao;
import br.unipar.programacaointernet.trabalhopdv.model.Itens_Venda;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class Itens_VendaService {
    @Inject
    private Itens_VendaDao itensVendaDao;

    public List<Itens_Venda> listarItensVendas(){
        return itensVendaDao.listarItensVenda();
    }

    public Itens_Venda listarItensVendaById(Integer id) throws Exception {
        return itensVendaDao.listarItensVendaById(id);
    }

    public void cadastrarItensVenda(Itens_Venda itensVenda) throws Exception{
        itensVendaDao.cadastrarItensVenda(itensVenda);
    }

    public void deletarItensVenda(Itens_Venda itensVenda)throws Exception{
        itensVendaDao.deletarItensVenda(itensVenda);
    }

    public void atualizarItensVenda(Itens_Venda itensVenda) throws Exception{
        itensVendaDao.atualizarItensVenda(itensVenda);
    }
}
