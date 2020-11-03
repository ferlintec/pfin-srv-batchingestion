package br.com.bradesco.pfiningestion.FormatarDependente.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bradesco.pfiningestion.FormatarDependente.vos.AgteMercdDepdtPlanjFincrVO;

@Configuration
public class FormatarDependenteStepConfig {
    @Autowired
    private StepBuilderFactory factory;

    @Bean("formatarDependenteStep")
    public Step execute(
        @Qualifier("executeAgteMercdDepdtPlanjFincrVOReader") ItemReader<AgteMercdDepdtPlanjFincrVO> reader,
        @Qualifier("executeAgteMercdDepdtPlanjFincrWriter") ItemWriter<AgteMercdDepdtPlanjFincrVO> writer
    ) {
        return factory
            .get("formatarDependenteStep")
            .<AgteMercdDepdtPlanjFincrVO, AgteMercdDepdtPlanjFincrVO>chunk(1)
            .reader(reader)
            .writer(writer)
            .build();
    }
}
