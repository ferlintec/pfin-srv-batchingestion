package br.com.bradesco.pfiningestion.jobs;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringRunner.class)
@ContextConfiguration("application.properties")
@SpringBatchTest
@EnableAutoConfiguration
@TestExecutionListeners({ 
    DependencyInjectionTestExecutionListener.class, 
    DirtiesContextTestExecutionListener.class}
)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public class IngestionJobTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @BeforeEach
    void init() {
    }

    @After
    public void finalize() {
        jobRepositoryTestUtils.removeJobExecutions();
    }

    @Test
    public void deveExecutarUmJobComSucesso() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        JobInstance actualJobInstance = jobExecution.getJobInstance();
        ExitStatus actualJobExitStatus = jobExecution.getExitStatus();

        assertEquals(actualJobInstance.getJobName(), is("ExecuteIngestionJob"));
        assertEquals(actualJobExitStatus, is("COMPLETED"));
    }
}
