package br.com.leangua.acessos.Acesso.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class UsuarioClientDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();
    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404){
            throw new UsuarioNaoEncontradoException();
        } else{
            return errorDecoder.decode(methodKey, response);
        }
    }
}
