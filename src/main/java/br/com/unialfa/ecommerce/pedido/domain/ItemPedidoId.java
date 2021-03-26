package br.com.unialfa.ecommerce.pedido.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import br.com.unialfa.ecommerce.pedido.domain.Pedido;
import br.com.unialfa.ecommerce.produto.domain.Produto;

@Embeddable
public class ItemPedidoId implements Serializable{

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    public ItemPedidoId(){

    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ItemPedidoId(Pedido pedido, Produto produto) {
        this.pedido = pedido;
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
        result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
        ItemPedidoId other = (ItemPedidoId) obj;
        if (pedido == null) {
            if (other.pedido != null)
                return false;
        } else if (!pedido.equals(other.pedido))
            return false;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        return true;
    }

    
}
