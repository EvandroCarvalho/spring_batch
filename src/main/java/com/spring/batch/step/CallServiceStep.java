package com.spring.batch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.spring.batch.Model.Cep;
import com.spring.batch.listener.ListenerService;
import com.spring.batch.service.ServiceCep;
import com.spring.batch.writer.WriterCep;

@Component
public class CallServiceStep {

  @Autowired
  public StepBuilderFactory step;
  
  @Autowired
  public WriterCep writer;
  
  @Autowired
  RestTemplate restTemplate;
  
  @Autowired
  ListenerService listenerService;
  
//  @Autowired
//  private ServiceCep service;

  public Step step() {
    return step.get("step")
        .<Cep, Cep>chunk(10)
        .listener(listenerService)
        .reader(new ListItemReader<Cep>(new ServiceCep(restTemplate).getCepDetails()))
        .writer(writer)
        .build();
  }

}
