package br.com.unialfa.ecommerce.cliente.service;

import br.com.unialfa.ecommerce.cliente.business.ClienteBusiness;
import br.com.unialfa.ecommerce.cliente.domain.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteBusiness clienteBusiness;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Cliente> listarCliente(){
        return clienteBusiness.listarCliente();
    }

    @PostMapping(path = "/cadastrar")
    public void cadastrarCliente(@RequestBody Cliente cliente){
        clienteBusiness.cadastrarCliente(cliente);
    }

    @PutMapping(path = "/editar")
    public void editarCliente(@RequestBody Cliente cliente){
        clienteBusiness.editarCliente(cliente);
    }

    @DeleteMapping(path="/deletar/{id}")
    public @ResponseBody void deletarCliente(@PathVariable(name="id") long id){
        clienteBusiness.deletarCliente(id);
    }
}
