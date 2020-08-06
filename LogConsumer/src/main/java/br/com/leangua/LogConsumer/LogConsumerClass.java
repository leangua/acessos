package br.com.leangua.LogConsumer;

import br.com.leangua.acessos.Acesso.dto.LogAcessoDto;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogConsumerClass {

    @Autowired
    GravarArquivoLog gravarArquivoLog;

    @KafkaListener(topics = "spec3-leandro-guarino-1", groupId = "leandro-guarino")
    public void receber(@Payload LogAcessoDto logAcessoDto) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        gravarArquivoLog.persistirLog(logAcessoDto);
        System.out.println("Log de acesso: " + logAcessoDto.getClienteId() +
                "Porta: " + logAcessoDto.getPortaId());
    }
}
