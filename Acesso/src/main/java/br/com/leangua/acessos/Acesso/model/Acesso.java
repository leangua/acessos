package br.com.leangua.acessos.Acesso.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Acesso {

    @EmbeddedId
    private AcessoId acessoId;

    public AcessoId getAcessoId() {
        return acessoId;
    }

    public void setAcessoId(AcessoId acessoId) {
        this.acessoId = acessoId;
    }
}
