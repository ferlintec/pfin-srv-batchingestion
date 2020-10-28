package br.com.bradesco.pfiningestion.FormatarDependente.writers;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bradesco.pfiningestion.FormatarDependente.entities.FormatarDependente;

@Configuration
public class FormatarDependenteWriterConfig {
    @Bean("executeFormataDependenteWriter")
    public ItemWriter<FormatarDependente> execute() {
        return formatarDependentes -> formatarDependentes.forEach(System.out::println); 
    }
}
