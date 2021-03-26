package br.com.unialfa.ecommerce.cliente.repository;

import br.com.unialfa.ecommerce.cliente.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
