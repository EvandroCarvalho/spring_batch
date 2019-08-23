
package com.spring.batch.quartz;

import java.util.Map;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobLauncherDetails extends QuartzJobBean {
  static final String JOB_NAME = "importUserJob";

  public void setJobLocator(JobLocator jobLocator) {
    this.jobLocator = jobLocator;
  }

  public void setJobLauncher(JobLauncher jobLauncher) {
    this.jobLauncher = jobLauncher;
  }

  private JobLocator jobLocator;
  private JobLauncher jobLauncher;

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext)
      throws JobExecutionException {
    JobParameters jobParameters =
        new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
    try {
      Map<String, Object> jobDataMap = jobExecutionContext.getMergedJobDataMap();
      String jobName = (String) jobDataMap.get(JOB_NAME);
      jobLauncher.run(jobLocator.getJob(jobName), jobParameters);
    } catch (JobExecutionAlreadyRunningException | JobRestartException
        | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
      e.printStackTrace();
    } catch (NoSuchJobException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
