package br.com.bradesco.pfiningestion.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bradesco.pfiningestion.domain.entities.Pessoa;

@Configuration
public class Step1 {

    @Autowired
    private StepBuilderFactory factory;

    @Bean("executeStep1")
    public Step execute(
        @Qualifier("executePessoaReader") ItemReader<Pessoa> executePessoaReader,
        @Qualifier("executePessoaWriter") ItemWriter<Pessoa> executePessoaWriter
        ) {
        return factory
            .get("executeStep1")
            .<Pessoa, Pessoa>chunk(1)
            .reader(executePessoaReader)
            .writer(executePessoaWriter)
            .build();
    }


}
