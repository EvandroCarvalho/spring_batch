package com.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.spring.batch.step.CallServiceStep;

@Component
public class JobService {

  @Autowired
  private JobBuilderFactory job;
  
  @Bean("importUserJob")
  public Job importUserJob(CallServiceStep step, com.spring.batch.listener.JobListener listener) {
    return job.get("importUserJob")
        .incrementer(new RunIdIncrementer())
        .listener(listener)
        .flow(step.step()).end().build();
  }

}
