package com.spring.batch.listener;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;
import com.spring.batch.Model.Cep;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ListenerService implements ItemReadListener<Cep>{

  @Override
  public void beforeRead() {
    // TODO Auto-generated method stub
    log.info("###Chamando o job");
  }

  @Override
  public void afterRead(Cep item) {
    
  }

  @Override
  public void onReadError(Exception ex) {
    // TODO Auto-generated method stub
    
  }

}
