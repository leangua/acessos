package br.com.leangua.acessos.Acesso.config;

import br.com.leangua.acessos.Acesso.exception.PortaClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PortaClientConfiguration {

    @Bean
    public ErrorDecoder getErrorDecoder(){
        return new PortaClientDecoder();
    }
}
