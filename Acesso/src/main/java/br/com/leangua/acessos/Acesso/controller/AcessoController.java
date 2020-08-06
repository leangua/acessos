package br.com.leangua.acessos.Acesso.controller;

import br.com.leangua.acessos.Acesso.model.Acesso;
import br.com.leangua.acessos.Acesso.model.AcessoId;
import br.com.leangua.acessos.Acesso.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AcessoController {

    @Autowired
    AcessoService acessoService;

    @PostMapping("/acesso")
    public Acesso cadastraAcesso(@RequestBody AcessoId acessoId){
        return acessoService.cadastraAcesso(acessoId);
    }

    @GetMapping("/acesso/{usuarioId}/{portaId}")
    public Acesso consultaAcesso(@PathVariable int usuarioId, @PathVariable int portaId){
        return acessoService.consultaAcesso(usuarioId, portaId);
    }

    @DeleteMapping("/acesso/{usuarioId}/{portaId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deletarAcesso(@PathVariable int usuarioId, int portaId){
        try{
            acessoService.deletaAcesso(usuarioId, portaId);
        } catch (RuntimeException e){
            System.out.println("Usuario - Erro na criacao do usuario");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
