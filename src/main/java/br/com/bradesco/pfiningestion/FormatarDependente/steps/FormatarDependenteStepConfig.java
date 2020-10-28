package br.com.bradesco.pfiningestion.FormatarDependente.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bradesco.pfiningestion.FormatarDependente.entities.FormatarDependente;

@Configuration
public class FormatarDependenteStepConfig {
    @Autowired
    private StepBuilderFactory factory;

    @Bean("formatarDependenteStep")
    public Step execute(
        @Qualifier("executeFormataDependenteReader") ItemReader<FormatarDependente> reader,
        @Qualifier("executeFormataDependenteWriter") ItemWriter<FormatarDependente> writer
    ) {
        return factory
            .get("formatarDependenteStep")
            .<FormatarDependente, FormatarDependente>chunk(1)
            .reader(reader)
            .writer(writer)
            .build();
    }
}
