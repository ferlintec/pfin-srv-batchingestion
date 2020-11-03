package br.com.bradesco.pfiningestion.FormatarDependente.writers;


import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.bradesco.pfiningestion.FormatarDependente.vos.AgteMercdDepdtPlanjFincrVO;

@Configuration
public class FormatarDependenteWriterConfig {
    
    @StepScope
    @Bean("executeAgteMercdDepdtPlanjFincrWriter")
    public FlatFileItemWriter<AgteMercdDepdtPlanjFincrVO> execute(
        @Value("#{jobParameters['fileAgteMercdDepdtPlanjFincr']}") Resource resource
    ) {
        return new FlatFileItemWriterBuilder<AgteMercdDepdtPlanjFincrVO>()
            .name("fileAgteMercdDepdtPlanjFincrVO")
            .resource(resource)
            .delimited()
            .delimiter(";")
            .names(
                "nPssoaDepdtPlanjFincr",
                "nAgteMercdPlanjFincr",
                "cBco",
                "iAgteMercdPlanjFincr",
                "cUsuarIncl",
                "hInclReg"
            )
            .build();
    }
}
