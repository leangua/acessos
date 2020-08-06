package br.com.leangua.acessos.Usuarios.services;

import br.com.leangua.acessos.Usuarios.exceptions.UsuarioNotFoundException;
import br.com.leangua.acessos.Usuarios.models.Usuario;
import br.com.leangua.acessos.Usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario criaUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario usuarioFindById(int id){
        return usuarioRepository.findById(id).orElseThrow(UsuarioNotFoundException::new);
    }
}
