package br.unipar.programacaointernet.trabalhopdv.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 100)
    private BigDecimal total;
    @Column(length = 1000)
    private String observacao;
    @ManyToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "venda", orphanRemoval = true)
    private List<Itens_Venda> itensVenda;


    public Venda(BigDecimal total, String observacao, Cliente cliente) {
        this.total = total;
        this.observacao = observacao;
        this.cliente = cliente;
    }

    public Venda(){

    }
}
