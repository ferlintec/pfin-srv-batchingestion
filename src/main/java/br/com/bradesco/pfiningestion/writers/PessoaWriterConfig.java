package br.com.bradesco.pfiningestion.writers;


import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.bradesco.pfiningestion.domain.entities.Pessoa;

@Configuration
public class PessoaWriterConfig {
    @Bean("executePessoaWriter")
    public ItemWriter<Pessoa> execute() {
        return pessoas -> pessoas.forEach(System.out::println);
    }
}
