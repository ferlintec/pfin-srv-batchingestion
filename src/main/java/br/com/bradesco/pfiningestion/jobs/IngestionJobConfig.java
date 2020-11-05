package br.com.bradesco.pfiningestion.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;


@EnableBatchProcessing
@Configuration
public class IngestionJobConfig {
    @Autowired
    private JobBuilderFactory factory;

    @Bean("executeIngestionJob")
    public Job execute(
        @Qualifier("agteMercdDepdtPlanjFincrStep") Step agteMercdDepdtPlanjFincrStep,
        @Qualifier("dependenteStep") Step dependenteStep
    ) {
        return factory
            .get("executeIngestionJob")
            .start(formatarDependenteUnloadParallel(agteMercdDepdtPlanjFincrStep, dependenteStep))
            .end()
            .incrementer(new RunIdIncrementer())
            .build();
    }

    private Flow formatarDependenteUnloadParallel(Step agteMercdDepdtPlanjFincrStep, Step dependenteStep) {
        Flow dependenteFlow = new FlowBuilder<Flow>("dependenteFlow")
            .start(dependenteStep)
            .build();
        
        Flow parallelSteps = new FlowBuilder<Flow>("parallelStepsFlow")
            .start(agteMercdDepdtPlanjFincrStep)
            .split(new SimpleAsyncTaskExecutor())
            .add(dependenteFlow)
            .build();
        return parallelSteps;
    }
}
