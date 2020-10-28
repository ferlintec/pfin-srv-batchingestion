package br.com.bradesco.pfiningestion.FormatarDependente.readers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.bradesco.pfiningestion.FormatarDependente.entities.FormatarDependente;

@Configuration
public class FormatarDependenteReaderConfig {

    private String getQuery() {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from dbo.tAgteMercdDepdtPlanjFincr as agenteMercadoDependente");
        builder.append("    inner join dbo.tAgteMercdPlanjFincr as agenteMercadoPlanFinanc");
        builder.append("    on agenteMercadoDependente.nAgteMercdPlanjFincr = agenteMercadoPlanFinanc.nAgteMercdPlanjFincr");
        builder.append("    order by nPssoaDepdtPlanjFincr");
        return builder.toString();
    }
    
    @Bean("executeFormataDependenteReader")
    public JdbcCursorItemReader<FormatarDependente> execute(@Qualifier("pfinDataSource") DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<FormatarDependente>()
            .name("executeFormataDependenteReader")
            .dataSource(dataSource)
            .sql(getQuery())
            .rowMapper(new BeanPropertyRowMapper<FormatarDependente>(FormatarDependente.class))
            .build();
    }
}
