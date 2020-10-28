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
public class IngestionJobConfig {
    @Autowired
    private JobBuilderFactory factory;

    @Bean("executeIngestionJob")
    public Job execute(@Qualifier("formatarDependenteStep") Step formatarDependente) {
        return factory
            .get("executeIngestionJob")
            .start(formatarDependente)
            .incrementer(new RunIdIncrementer())
            .build();
    }
}
