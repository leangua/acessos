package br.com.leangua.acessos.Acesso.clients;

import br.com.leangua.acessos.Acesso.config.PortaClientConfiguration;
import br.com.leangua.acessos.Acesso.model.Porta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "porta", configuration = PortaClientConfiguration.class)
public interface PortaClient {

    @GetMapping("/porta/{id}")
    public Porta buscaPorta(@PathVariable int id);
}
