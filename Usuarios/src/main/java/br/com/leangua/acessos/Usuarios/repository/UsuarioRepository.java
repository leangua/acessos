package br.com.leangua.acessos.Usuarios.repository;

import br.com.leangua.acessos.Usuarios.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}
