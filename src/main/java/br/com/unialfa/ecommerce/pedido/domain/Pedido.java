package br.com.unialfa.ecommerce.pedido.domain;

import br.com.unialfa.ecommerce.cliente.domain.Cliente;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dataCriacaoPedido;
    private LocalDate dataUltimaAtualizacao;
    private LocalDate dataconclusao;

    @Column(nullable = false)
    private BigDecimal subtotal;
    private BigDecimal total;
    private BigDecimal valorFrete;


    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido")
    private List<ItemPedido> itensPedido;

    public Pedido() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataCriacaoPedido() {
        return dataCriacaoPedido;
    }

    public void setDataCriacaoPedido(LocalDate dataCriacaoPedido) {
        this.dataCriacaoPedido = dataCriacaoPedido;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public LocalDate getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(LocalDate dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

}
