package br.com.bradesco.pfiningestion.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Step1 {

    @Autowired
    private StepBuilderFactory factory;

    @Bean("executeStep1")
    public Step execute() {
        return factory
            .get("executeStep1")
            .tasklet(new Tasklet() {
				@Override
				public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
					System.out.println("executeStep1");
					return RepeatStatus.FINISHED;
				}
            })
            .build();
    }


}
