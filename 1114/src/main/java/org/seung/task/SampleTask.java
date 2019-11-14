package org.seung.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SampleTask {

	@Scheduled(cron = "0 * * * * *")
	public void doJob() {
		System.out.println("==================================");
		System.out.println("==================================");
		System.out.println("==================================");
		System.out.println("==================================");
		System.out.println("==================================");
	}
	
}
