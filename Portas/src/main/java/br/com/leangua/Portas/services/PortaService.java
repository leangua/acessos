package br.com.leangua.Portas.services;

import br.com.leangua.Portas.exceptions.PortaNotFoundException;
import br.com.leangua.Portas.models.Porta;
import br.com.leangua.Portas.repositories.PortaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class PortaService {

    @Autowired
    PortaRepository portaRepository;

    public Porta cadastrarPorta(Porta porta){
        return portaRepository.save(porta);
    }

    public Porta buscaPortaPorId(int id){
        return portaRepository.findById(id).orElseThrow(PortaNotFoundException::new);
    }
}
