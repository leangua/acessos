package br.com.leangua.Portas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Porta nao cadastrada")
public class PortaNotFoundException extends RuntimeException {
}
