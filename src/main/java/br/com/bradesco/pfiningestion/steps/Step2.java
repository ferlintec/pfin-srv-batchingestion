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
public class Step2 {

    @Autowired
    private StepBuilderFactory factory;

    @Bean("executeStep2")
    public Step execute() {
        return factory
            .get("executeStep2")
            .tasklet(new Tasklet() {
				@Override
				public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
					System.out.println("executeStep2");
					return RepeatStatus.FINISHED;
				}
            })
            .build();
    }


}
