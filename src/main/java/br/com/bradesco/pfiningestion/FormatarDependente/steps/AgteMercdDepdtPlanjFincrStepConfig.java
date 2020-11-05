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
public class AgteMercdDepdtPlanjFincrStepConfig {
    @Autowired
    private StepBuilderFactory factory;

    @Bean("agteMercdDepdtPlanjFincrStep")
    public Step execute(
        @Qualifier("executeAgteMercdDepdtPlanjFincrReader") ItemReader<AgteMercdDepdtPlanjFincrVO> reader,
        @Qualifier("executeAgteMercdDepdtPlanjFincrWriter") ItemWriter<AgteMercdDepdtPlanjFincrVO> writer
    ) {
        return factory
            .get("agteMercdDepdtPlanjFincrStep")
            .<AgteMercdDepdtPlanjFincrVO, AgteMercdDepdtPlanjFincrVO>chunk(1)
            .reader(reader)
            .writer(writer)
            .build();
    }
}
