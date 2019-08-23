//package com.spring.batch;
//
//import java.util.Date;
//
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import com.spring.batch.config.BatchConfiguration;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//public class ExecutingJob implements org.quartz.Job {
//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//
//	@Override
//	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//	    context.register(BatchConfiguration.class);
//	    context.refresh();
//	    JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
//	    Job job = (Job) context.getBean("importUserJob");
//
//		try {
//			 jobLauncher.run(
//					 job, new JobParametersBuilder().addDate("Date", new Date()).toJobParameters()
//					 );
//		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
//				| JobParametersInvalidException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
