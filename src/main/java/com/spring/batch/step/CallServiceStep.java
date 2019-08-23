package com.spring.batch.step;

import com.spring.batch.writer.SalveCepDataBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.spring.batch.Model.CepResponse;
import com.spring.batch.listener.ListenerService;
import com.spring.batch.service.ServiceCep;
import com.spring.batch.writer.WriterCep;

import java.util.Arrays;

@Component
@Slf4j
public class CallServiceStep {
  @Autowired
  ApplicationContext applicationContext;

  @Autowired
  public StepBuilderFactory step;

  @Autowired
  public WriterCep writerCep;

  @Autowired
  public SalveCepDataBase salveCepDataBase;

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  ListenerService listenerService;

  @Autowired
  ServiceCep serviceCep;

  @Autowired
  @Qualifier("readerCep")
  ListItemReader reader;

  public CompositeItemWriter compositeItemWriter() {
    CompositeItemWriter compositeItemWriter = new CompositeItemWriter();
    compositeItemWriter.setDelegates(Arrays.asList(writerCep, salveCepDataBase));
    return compositeItemWriter;
  }






  public Step step() {
    return step.get("stepServiceCep")
        .<CepResponse, CepResponse>chunk(10)
        .listener(listenerService)
        .reader(reader)
        .writer(compositeItemWriter())
        .build();
  }

}
