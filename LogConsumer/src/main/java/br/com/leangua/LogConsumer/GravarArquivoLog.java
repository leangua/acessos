package br.com.leangua.LogConsumer;

import br.com.leangua.acessos.Acesso.dto.LogAcessoDto;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class GravarArquivoLog {

    public void persistirLog(LogAcessoDto logDto) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = Files.newBufferedWriter(Paths.get("logAcessos.csv"));
        StatefulBeanToCsv<LogAcessoDto> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(logDto);

        writer.flush();
        writer.close();
    }
}
