package br.com.bradesco.pfiningestion.FormatarDependente.writers;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import br.com.bradesco.pfiningestion.FormatarDependente.vos.DependenteVO;

@Configuration
public class DependenteWriterConfig {
    
    @StepScope
    @Bean("executeDependenteWriter")
    public FlatFileItemWriter<DependenteVO> execute(
        @Value("#{jobParameters['fileDependente']}") Resource resource
    ) {
        return new FlatFileItemWriterBuilder<DependenteVO>()
            .name("executeDependenteWriter")
            .resource(resource)
            .delimited()
            .delimiter(";")
            .names(
                "nPssoaDepdtPlanjFincr",
                "nPssoaPlanjFincr",
                "cCategVnclo",
                "cTpoVnclo",
                "cIndcdDepdcPssoa",
                "cCpfDepdtPssoaPlanjFincr",
                "cCtrlCpfDepdtPssoaPlanjFincr",
                "dNascDepdtPssoaPlanjFincr",
                "rInfoFincrDepdt",
                "cSiteReg",
                "cUsuarIncl",
                "hInclReg",
                "hUltAltReg"
            )
            .build();
    }
}
