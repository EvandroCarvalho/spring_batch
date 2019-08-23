package com.spring.batch.writer;

import com.spring.batch.Entity.Cep;
import com.spring.batch.Model.CepResponse;
import com.spring.batch.mapper.ToCepEntityMapper;
import com.spring.batch.repository.CepRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.support.ListItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evandro Carvalho
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SalveCepDataBase implements ItemWriter<CepResponse> {

    private final CepRepository cepRepository;

    @Override
    public void write(List<? extends CepResponse> ceps) throws Exception {
        try {
            for(CepResponse cepResponse : ceps) {
                Cep cep = ToCepEntityMapper.convertToCep(cepResponse);
                 cep = cepRepository.save(cep);
                log.info("###Cep Salvo!!" + cep.toString());
            }
        }catch (Exception e) {
            log.info("###Erro ao salver: " + e.getMessage());
        }
    }
}
