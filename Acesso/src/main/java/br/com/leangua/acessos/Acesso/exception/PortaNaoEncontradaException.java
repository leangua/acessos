package br.com.leangua.acessos.Acesso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "porta nao encontrada" )
public class PortaNaoEncontradaException extends RuntimeException {
}
