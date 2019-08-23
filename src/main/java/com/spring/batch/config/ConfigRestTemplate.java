package com.spring.batch.config;

import com.spring.batch.service.ServiceCep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@Slf4j
public class ConfigRestTemplate {

  @Autowired
  ServiceCep serviceCep;
  
  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplateBuilder().build();
  }

  @Bean("readerCep")
  @StepScope
  public ListItemReader getListItemReader() {
    return new ListItemReader(serviceCep.getCepDetails());
  }
}