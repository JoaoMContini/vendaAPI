package br.unipar.programacaointernet.trabalhopdv.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 1000)
    private String descricao;
    @Column(length = 100)
    private BigDecimal valor_unitario;

    public Produto(String descricao, BigDecimal valor_unitario) {
        this.descricao = descricao;
        this.valor_unitario = valor_unitario;
    }

    public Produto(){

    }
}
