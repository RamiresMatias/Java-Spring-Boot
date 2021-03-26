package br.com.unialfa.ecommerce.pedido.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.unialfa.ecommerce.pedido.domain.ItemPedido;
import br.com.unialfa.ecommerce.pedido.domain.ItemPedidoId;

public interface ItensPedidoRepository extends CrudRepository<ItemPedido, ItemPedidoId>{
    
}
