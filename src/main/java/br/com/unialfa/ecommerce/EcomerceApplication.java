package br.com.unialfa.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.unialfa.ecommerce.cliente.domain.Cliente;
import br.com.unialfa.ecommerce.cliente.repository.ClienteRepository;
import br.com.unialfa.ecommerce.pedido.domain.ItemPedido;
import br.com.unialfa.ecommerce.pedido.domain.Pedido;
import br.com.unialfa.ecommerce.pedido.repository.ItensPedidoRepository;
import br.com.unialfa.ecommerce.pedido.repository.PedidoRepository;
import br.com.unialfa.ecommerce.produto.domain.Produto;
import br.com.unialfa.ecommerce.produto.repository.ProdutoRepository;

@SpringBootApplication
public class EcomerceApplication {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired 
	private ItensPedidoRepository itensPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		Cliente cliente = new Cliente();
		cliente.setNome("ClienteTeste");
		cliente.setCpf("111.111.111-11");
		cliente.setDataNascimento(LocalDate.now());
		cliente.setVersao(1);
		cliente.setPrimeiroNome("Teste");
		clienteRepository.save(cliente);


		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacaoPedido(LocalDate.now());
		pedido.setDataUltimaAtualizacao(LocalDate.now());
		pedido.setDataconclusao(LocalDate.now());
		pedido.setSubtotal(BigDecimal.ZERO);
		pedido.setTotal(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);

		pedidoRepository.save(pedido);

		List<Produto> produtos = new ArrayList<>();

		Produto produto = new Produto();
		produto.setAtivo(true);
		produto.setNome("produto1");
		produto.setDescricao("Produto teste 1");
		produto.setPreco(BigDecimal.valueOf(10.00));
		produtos.add(produto);

		Produto produto2 = new Produto();
		produto.setAtivo(true);
		produto.setNome("produto2");
		produto.setDescricao("Produto teste 2");
		produto.setPreco(BigDecimal.valueOf(100.00));
		produtos.add(produto2);

		produtoRepository.saveAll(produtos);

		List<ItemPedido> itensPedidos = new ArrayList<>();
		ItemPedido itensPedido = new ItemPedido(pedido, produto, 1);

		ItemPedido itensPedido2 = new ItemPedido(pedido, produto2, 2);
		itensPedidos.add(itensPedido);
		itensPedidos.add(itensPedido2);

		itensPedidoRepository.saveAll(itensPedidos);
	
		return null;
	}

}
