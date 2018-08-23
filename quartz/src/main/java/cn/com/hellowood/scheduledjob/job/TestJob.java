package cn.com.hellowood.scheduledjob.job;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class TestJob implements Job {

    private final Logger logger = LoggerFactory.getLogger(TestJob.class);
    private static RestTemplate restTemplate = new RestTemplate();

    @Override
    public void execute(JobExecutionContext Context) throws JobExecutionException {
        // Do what you want here
    	logger.info("Test job is executing...");
    	

    }
}
