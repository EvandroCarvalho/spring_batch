package com.spring.batch.writer;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import com.spring.batch.Model.Cep;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WriterCep implements ItemWriter<Cep> {

  @Override
  public void write(List<? extends Cep> cep) throws Exception {
    log.info("####Writer: " + cep.toString());

  }

}
