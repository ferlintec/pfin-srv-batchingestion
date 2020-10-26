package br.com.bradesco.pfiningestion.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class IngestionJob {
    @Autowired
    private JobBuilderFactory factory;

    @Bean
    public Job execute(
        @Qualifier("executeStep1") Step step1,
        @Qualifier("executeStep2") Step step2) {

            Job build = factory
                .get("execute")
                .start(step1)
                .next(step2)
                .incrementer(new RunIdIncrementer())
                .build();
            return build;
    }
}
