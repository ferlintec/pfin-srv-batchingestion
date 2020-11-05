package br.com.bradesco.pfiningestion.jobs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.bradesco.pfiningestion.BatchTestConfig;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
    IngestionJobConfig.class,
    BatchTestConfig.class,
    ExtractJobLauncherTestUtils.class,
})
@JdbcTest
@EnableBatchProcessing
@SpringBatchTest
public class IngestionJobTest {

    @Autowired
    @Qualifier(value = "extractJobLauncherTestUtils")
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Before
    public void init() {
    }

    @Test
    public void deveExecutarUmJobComSucesso() throws Exception {
        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        // then
        Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }
}

@Component(value = "extractJobLauncherTestUtils")
class ExtractJobLauncherTestUtils extends JobLauncherTestUtils {

    @Autowired
    @Qualifier(value = "executeIngestionJob")
    @Override
    public void setJob(Job job) {
        super.setJob(job);
    }
}
