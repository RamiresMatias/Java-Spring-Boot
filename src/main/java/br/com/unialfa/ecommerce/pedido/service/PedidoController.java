package br.com.unialfa.ecommerce.pedido.service;

import br.com.unialfa.ecommerce.cliente.domain.Cliente;
import br.com.unialfa.ecommerce.pedido.domain.Pedido;
import br.com.unialfa.ecommerce.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(path = "/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pedido> listarPedido(@PathVariable Long idCliente){
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        return pedidoRepository.findByCliente(cliente);
    }

    @PostMapping(path = "/cadastrar")
    public void cadastrarPedido(@RequestBody Pedido pedido){
        pedidoRepository.save(pedido);
    }

    @PutMapping(path = "/editar")
    public void editarPedido(@RequestBody Pedido pedido){
        pedidoRepository.save(pedido);
    }

    @DeleteMapping(path="/deletar/{id}")
    public @ResponseBody void deletarPedido(@PathVariable(name="id") long id){
        pedidoRepository.deleteById(id);
    }
}
