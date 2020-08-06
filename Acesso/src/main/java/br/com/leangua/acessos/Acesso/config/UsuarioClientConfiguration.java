package br.com.leangua.acessos.Acesso.config;

import br.com.leangua.acessos.Acesso.exception.UsuarioClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class UsuarioClientConfiguration {

    @Bean
    public ErrorDecoder getErrorDecoder(){
        return new UsuarioClientDecoder();
    }
}
