package br.com.leangua.acessos.Acesso.dto;

public class LogAcessoDto {

    private int clienteId;

    private int portaId;

    private boolean acessoConcedido;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getPortaId() {
        return portaId;
    }

    public void setPortaId(int portaId) {
        this.portaId = portaId;
    }

    public boolean isAcessoConcedido() {
        return acessoConcedido;
    }

    public void setAcessoConcedido(boolean acessoConcedido) {
        this.acessoConcedido = acessoConcedido;
    }
}
