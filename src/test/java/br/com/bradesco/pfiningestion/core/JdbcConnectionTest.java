package br.com.bradesco.pfiningestion.core;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import br.com.bradesco.pfiningestion.config.DataSourceConfigImpl;
import br.com.bradesco.pfiningestion.core.vos.JdbcConnectionVO;
import br.com.bradesco.pfiningestion.core.vos.builders.JdbcConnectionBuilder;

@SpringBootTest
@ContextConfiguration(classes = { DataSourceConfigImpl.class })
public class JdbcConnectionTest {

    private DataSource dataSource;

    private JdbcConnectionVO connection;

	private PreparedStatement prepareStatement;

    @BeforeAll
    public void setUp() {
    }

    @Test
    @DisplayName("Deve conectar no banco de dados com sucesso")
    public void deveConectarComSucesso() throws SQLException {
        connection = JdbcConnectionBuilder.create().build();
        // Given a connection
        dataSource = getDataSourceConnection();
        Connection connectionDataSource = dataSource.getConnection();

        // When the connection
        connectionDataSource.createStatement();
        prepareStatement = connectionDataSource.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.TABLES");
        ResultSet result = prepareStatement.executeQuery();
        // Then the connection is
        assertNotNull(dataSource);
        assertNotNull(connectionDataSource);
        assertNotNull(result);
        connectionDataSource.close();
    }

    @Test
    @DisplayName("Deve gerar erro quando url estiver inválida")
    public void deveGerarErroQuandoUrlEstiverInvalida() throws SQLException {
        connection = JdbcConnectionBuilder
            .create()
            .withUrl("")
            .build();
        // Given a connection
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dataSource = getDataSourceConnection();
            Connection connectionDataSource = dataSource.getConnection();
            connectionDataSource.close();
            
        });
        String expectedMessage = "jdbcUrl is required with driverClassName.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Deve gerar erro quando Driver Estiver inválido")
    public void deveGerarErroQuandoDriverEstiverInvalido() throws SQLException {
        connection = JdbcConnectionBuilder.create().withDriver("").build();
        // Given a connection
        Exception exception = assertThrows(BindException.class, () -> {
            dataSource = getDataSourceConnection();
            Connection connectionDataSource = dataSource.getConnection();
            connectionDataSource.close();

        });
        String expectedMessage = "Failed to bind properties under \'\' to com.zaxxer.hikari.HikariDataSource";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Deve gerar erro quando Username estiver inválido")
    public void deveGerarErroQuandoUsernameEstiverInvalido() throws SQLException {
        connection = JdbcConnectionBuilder.create().withUsername("").build();
        // Given a connection
        Exception exception = assertThrows(SQLServerException.class, () -> {
            dataSource = getDataSourceConnection();
            Connection connectionDataSource = dataSource.getConnection();
            connectionDataSource.close();
        });
        assertNotNull(exception);
    }

    @Test
    @DisplayName("Deve gerar erro quando Password estiver inválido")
    public void deveGerarErroQuandoPasswordEstiverInvalido() throws SQLException {
        connection = JdbcConnectionBuilder.create().withPassword("").build();
        // Given a connection
        Exception exception = assertThrows(SQLServerException.class, () -> {
            dataSource = getDataSourceConnection();
            Connection connectionDataSource = dataSource.getConnection();
            connectionDataSource.close();

        });
        assertNotNull(exception);
    }

    private DataSource getDataSourceConnection() {
        return DataSourceBuilder.create()
            .url(connection.getUrl())
            .driverClassName(connection.getDriver())
            .username(connection.getUsername())
            .password(connection.getPassword())
            .build();          
    }

}
