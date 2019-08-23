//package com.spring.batch;
//
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SimpleScheduleBuilder;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import lombok.SneakyThrows;
//
//@Component
//@Configuration
//public class QuartzConfig {
//	
//	@SneakyThrows
//	static void executingQuartz() {
//		Trigger trigger = TriggerBuilder.newTrigger()
//				.withIdentity("job trigger")
//				.withDescription("Job batch trigger")
//				.withSchedule(SimpleScheduleBuilder
//						.simpleSchedule()
//						.withIntervalInSeconds(5)
//						.repeatForever()
//						).build();
//		JobDetail batchJob = JobBuilder.newJob(ExecutingJob.class)
//				.withIdentity("job bach")
//				.withDescription("Job batch ever 3 sec")
//				.build();
//		
//		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//		scheduler.start();
//		scheduler.scheduleJob(batchJob, trigger);
//	}
//}
