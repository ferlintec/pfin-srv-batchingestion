package br.com.bradesco.pfiningestion.FormatarDependente.readers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.bradesco.pfiningestion.FormatarDependente.vos.DependenteVO;

@Configuration
public class DependenteReaderConfig {

    private String getQuery() {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from dbo.tPssoaDepdtPlanjFincr");
        builder.append("    order by nPssoaPlanjFincr");
        return builder.toString();
    }

    @Bean("executeDependenteReader")
    public JdbcCursorItemReader<DependenteVO> execute(@Qualifier("pfinDataSource") DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<DependenteVO>()
            .name("executeDependenteReader")
            .dataSource(dataSource)
            .sql(getQuery())
            .rowMapper(new BeanPropertyRowMapper<DependenteVO>(DependenteVO.class))
            .build();
    }
}
