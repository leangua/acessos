package br.com.leangua.acessos.Acesso.clients;

import br.com.leangua.acessos.Acesso.config.UsuarioClientConfiguration;
import br.com.leangua.acessos.Acesso.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario", configuration = UsuarioClientConfiguration.class)
public interface UsuarioClient {

    @GetMapping("/usuario/{id}")
    Usuario buscaUsuario(@PathVariable int id);
}
