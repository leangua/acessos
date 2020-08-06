package br.com.leangua.acessos.Acesso.service;

import br.com.leangua.acessos.Acesso.clients.PortaClient;
import br.com.leangua.acessos.Acesso.clients.UsuarioClient;
import br.com.leangua.acessos.Acesso.dto.LogAcessoDto;
import br.com.leangua.acessos.Acesso.model.Acesso;
import br.com.leangua.acessos.Acesso.model.AcessoId;
import br.com.leangua.acessos.Acesso.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AcessoService {

    @Autowired
    AcessoRepository acessoRepository;

    @Autowired
    UsuarioClient usuarioClient;

    @Autowired
    PortaClient portaClient;

    @Autowired
    LogProducer logProducer;

    public Acesso cadastraAcesso(AcessoId acessoid){
            usuarioClient.buscaUsuario(acessoid.getUsuarioId());
            portaClient.buscaPorta(acessoid.getPortaId());
            Acesso acesso = new Acesso();
            acesso.setAcessoId(acessoid);
            return acessoRepository.save(acesso);
    }

    public Acesso consultaAcesso(int clienteId, int portaId){
        AcessoId acessoId = new AcessoId();
        acessoId.setUsuarioId(clienteId);
        acessoId.setPortaId(portaId);
        Acesso acesso = acessoRepository.findByAcessoId(acessoId);
        LogAcessoDto logAcessoDto = new LogAcessoDto();
        logAcessoDto.setClienteId(acessoId.getUsuarioId());
        logAcessoDto.setPortaId(acessoId.getPortaId());
        logAcessoDto.setAcessoConcedido(true);
        logProducer.enviarAoKafka(logAcessoDto);
        return acesso;
    }

    public void deletaAcesso(int usuarioId, int portaId) {
        AcessoId acessoId = new AcessoId();
        acessoId.setUsuarioId(usuarioId);
        acessoId.setPortaId(portaId);
        acessoRepository.deleteByAcessoId(acessoId);
    }
}
