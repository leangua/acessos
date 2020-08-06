package br.com.leangua.acessos.Usuarios.controllers;

import br.com.leangua.acessos.Usuarios.models.Usuario;
import br.com.leangua.acessos.Usuarios.services.UsuarioService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    Usuario buscaUsuario(@PathVariable int id){
        return  usuarioService.usuarioFindById(id);
    }

    @PostMapping("/usuario")
    ResponseEntity<?> criaUsuario(@RequestBody Usuario usuario){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criaUsuario(usuario));
        } catch (RuntimeException exception){
            System.out.println("Usuario - Erro na criacao do usuario");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
