package br.com.bradesco.pfiningestion.FormatarDependente.readers;

import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import br.com.bradesco.pfiningestion.FormatarDependente.vos.AgteMercdDepdtPlanjFincrVO;

@Configuration
public class AgteMercdDepdtPlanjFincrReaderConfig {

    private String getQuery() {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from dbo.tAgteMercdDepdtPlanjFincr as agenteMercadoDependente");
        builder.append("    inner join dbo.tAgteMercdPlanjFincr as agenteMercadoPlanFinanc");
        builder.append("    on agenteMercadoDependente.nAgteMercdPlanjFincr = agenteMercadoPlanFinanc.nAgteMercdPlanjFincr");
        builder.append("    order by nPssoaDepdtPlanjFincr");
        return builder.toString();
    }
    
    @Bean("executeAgteMercdDepdtPlanjFincrVOReader")
    public JdbcCursorItemReader<AgteMercdDepdtPlanjFincrVO> execute(@Qualifier("pfinDataSource") DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<AgteMercdDepdtPlanjFincrVO>()
            .name("executeAgteMercdDepdtPlanjFincrVOReader")
            .dataSource(dataSource)
            .sql(getQuery())
            .rowMapper(new BeanPropertyRowMapper<AgteMercdDepdtPlanjFincrVO>(AgteMercdDepdtPlanjFincrVO.class))
            .build();
    }
}
