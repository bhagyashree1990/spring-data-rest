package com.sts.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ConditionalOnExpression("${app.scheduling.enabled:false}")	
public class ScheduledTaskConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTaskConfig.class);
	
	@Bean
	public ExecutorService getExecutorService() {
		return Executors.newFixedThreadPool(4);
	}
	
	public Runnable getTask() {
		return ()->{
			for(int i=1;i<=25;i++)
				LOGGER.info("Square:{} = {}",i,i*i);
		};
	}
	
	@Autowired
	private ExecutorService executorService;
	
	@Scheduled(cron = "0 * * * * ?")
	public void computeSquare() {
		LOGGER.info("COMPUTE SQUARE: ");
		executorService.execute(getTask());
	}
	
}
