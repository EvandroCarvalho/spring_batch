package com.spring.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobListener implements JobExecutionListener {

  @Override
  public void beforeJob(JobExecution jobExecution) {
    log.info("####Executando o job " + jobExecution.getJobId());

  }

  @Override
  public void afterJob(JobExecution jobExecution) {
    // TODO Auto-generated method stub

  }

}
