package com.senac.cadastro_cliente.controllers;

import com.senac.cadastro_cliente.model.Cliente;
import com.senac.cadastro_cliente.repositories.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;


    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

   // @GetMapping

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
    if (cliente.isPresent()){
        return cliente.get();
    } else {
        throw new EntityNotFoundException("Cliente não encontrado. ");
    }
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable("id") Integer id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if(clienteOptional.isPresent()){
            Cliente clienteSalvo = clienteOptional.get();
            clienteSalvo.setName(cliente.getName());

            return clienteRepository.save(clienteSalvo);
        }else {
            throw new EntityNotFoundException("Cliente nao encontrado. ");
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        clienteRepository.deleteById(id);
    }


}
