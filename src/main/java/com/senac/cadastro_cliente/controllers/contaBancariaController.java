package com.senac.cadastro_cliente.controllers;

import com.senac.cadastro_cliente.model.contaBancaria;
import com.senac.cadastro_cliente.repositories.ContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contas-bancarias")
public class contaBancariaController {

    private final ContaRepository contaRepository;

    public contaBancariaController(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }

    @GetMapping
    public Page<contaBancaria> findAll(@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
                                        @RequestParam(name = "registrosPorPagina", required = false, defaultValue = "3") int registrosPorPagina){
        PageRequest pageRequest = PageRequest.of(pageNumber, registrosPorPagina);
        return contaRepository.findAll(pageRequest);
    }

    @GetMapping("/{id}")
    public contaBancaria findById(@PathVariable("id") Integer id) {
        Optional<contaBancaria> contaBancaria = contaRepository.findById(id);

        if (contaBancaria.isPresent()){
            return contaBancaria.get();
        } else {
            throw new EntityNotFoundException("Conta bancária não encontrada. ");
        }
    }

    @PostMapping
    public contaBancaria save(@RequestBody contaBancaria conta) {
        return contaRepository.save(conta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        contaRepository.deleteById(id);
    }
}
