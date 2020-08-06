package br.com.leangua.acessos.Acesso.service;

import br.com.leangua.acessos.Acesso.dto.LogAcessoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogProducer {

    @Autowired
    private KafkaTemplate<String, LogAcessoDto> producer;

    public void enviarAoKafka(LogAcessoDto logAcessoDto){
        producer.send("spec3-leandro-guarino-1", logAcessoDto);
    }

}
