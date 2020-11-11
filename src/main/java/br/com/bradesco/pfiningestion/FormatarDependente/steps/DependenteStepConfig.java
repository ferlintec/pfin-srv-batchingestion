package br.com.bradesco.pfiningestion.FormatarDependente.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bradesco.pfiningestion.FormatarDependente.vos.DependenteVO;

@Configuration
public class DependenteStepConfig {
    @Autowired
    private StepBuilderFactory factory;

    @Bean("dependenteStep")
    public Step execute(
        @Qualifier("executeDependenteReader") ItemReader<DependenteVO> reader,
        @Qualifier("executeDependenteWriter") ItemWriter<DependenteVO> writer
    ) {
        return factory
            .get("dependenteStep")
            .<DependenteVO, DependenteVO>chunk(1)
            .reader(reader)
            .writer(writer)
            .build();
    }
}
