package br.com.bradesco.pfiningestion.readers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.bradesco.pfiningestion.domain.entities.Pessoa;

@Configuration
public class PessoaReaderConfig {
    @Bean("executePessoaReader")
    public JdbcCursorItemReader<Pessoa> execute(@Qualifier("pfinDataSource") DataSource datasource) {
        return new JdbcCursorItemReaderBuilder<Pessoa>()
            .name("executePessoaReader")
            .dataSource(datasource)
            .sql("SELECT * FROM Pessoa")
            .rowMapper(new BeanPropertyRowMapper<Pessoa>(Pessoa.class))
            .build();
    }
}
