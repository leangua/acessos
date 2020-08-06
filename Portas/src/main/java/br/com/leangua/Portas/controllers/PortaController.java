package br.com.leangua.Portas.controllers;

import br.com.leangua.Portas.models.Porta;
import br.com.leangua.Portas.services.PortaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PortaController {

    @Autowired
    PortaService portaService;

    @PostMapping("/porta")
    ResponseEntity<?> cadastraPorta(@RequestBody Porta porta){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(portaService.cadastrarPorta(porta));
        } catch (RuntimeException exception){
            System.out.println("Erro ao criar a porta");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @GetMapping("/porta/{id}")
    public Porta buscaPorta(@PathVariable int id){
        return portaService.buscaPortaPorId(id);
    }
}
