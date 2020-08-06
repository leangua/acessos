package br.com.leangua.acessos.Acesso.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AcessoId implements Serializable {
    private int usuarioId;
    private int portaId;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPortaId() {
        return portaId;
    }

    public void setPortaId(int portaId) {
        this.portaId = portaId;
    }
}
