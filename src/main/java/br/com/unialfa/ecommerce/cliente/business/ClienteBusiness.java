package br.com.unialfa.ecommerce.cliente.business;

import br.com.unialfa.ecommerce.cliente.domain.Cliente;
import br.com.unialfa.ecommerce.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClienteBusiness {

    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    public void cadastrarCliente(@RequestBody Cliente cliente){
        if(validarPcf(cliente.getCpf())){
            clienteRepository.save(cliente);
        }else{
            System.err.println("Cpf Inválido");
        }

    }

    public void editarCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void deletarCliente(@PathVariable(name="id") long id){
        clienteRepository.deleteById(id);
    }

    public boolean validarPcf(String cpf){
        boolean valido = false;
        if(cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222")
                || cpf.equals("33333333333")
                || cpf.equals("44444444444")
                || cpf.equals("55555555555")
                || cpf.equals("66666666666")
                || cpf.equals("77777777777")
                || cpf.equals("88888888888")
                || cpf.equals("99999999999")
                || (cpf.length() != 11)
        ) return(false);
        return true;
    }
}
