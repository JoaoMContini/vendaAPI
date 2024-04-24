package br.unipar.programacaointernet.trabalhopdv.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Itens_Venda implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column()
    private BigDecimal valor_unitario;
    @Column()
    private BigDecimal valor_total;
    @Column()
    private BigDecimal quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    @JsonIgnore
    private Venda venda;


    public Itens_Venda(BigDecimal valor_unitario, BigDecimal valor_total, BigDecimal quantidade, Produto produto, Venda venda) {
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
        this.quantidade = quantidade;
        this.produto = produto;
        this.venda = venda;
    }

    public Itens_Venda() {
    }
}
