package br.com.leangua.acessos.Usuarios.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Usuario não encontrado")
public class UsuarioNotFoundException extends RuntimeException{
}
