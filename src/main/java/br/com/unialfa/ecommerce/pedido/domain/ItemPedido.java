package br.com.unialfa.ecommerce.pedido.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import br.com.unialfa.ecommerce.produto.domain.Produto;

@Entity
public class ItemPedido implements Serializable {
    // Notação EmbeddedId indica que ela é criada em outra pasta e injetada nesta
    // classe
    @EmbeddedId
    private ItemPedidoId id;

    @Column(nullable = false)
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        this.id = new ItemPedidoId();
        this.quantidade = quantidade;
        id.setPedido(pedido);
        id.setProduto(produto);
    }

    public ItemPedidoId getId() {
        return id;
    }

    public void setId(ItemPedidoId id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + quantidade;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemPedido other = (ItemPedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (quantidade != other.quantidade)
            return false;
        return true;
    }

    

}
