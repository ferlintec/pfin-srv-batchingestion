package br.com.bradesco.pfiningestion.core.vos.builders;

import br.com.bradesco.pfiningestion.core.vos.JdbcConnectionVO;

public class JdbcConnectionBuilder {
    
    private JdbcConnectionVO connection;
    
    private JdbcConnectionBuilder() {
    }

    public static JdbcConnectionBuilder create() {
        JdbcConnectionBuilder builder = new JdbcConnectionBuilder();
        builder.connection = JdbcConnectionVO.of(
            "jdbc:sqlserver://localhost;databaseName=PFIND000",
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "sa", "P4ss-W0rd!Everis@2020");
        return builder;
    }

    public JdbcConnectionVO build() {
        return connection;
    }

    public JdbcConnectionBuilder withUsername(String username) {
        connection.setUsername(username);
        return this;
    }

    public JdbcConnectionBuilder withPassword(String password) {
        connection.setPassword(password);
        return this;
    }

    public JdbcConnectionBuilder withDriver(String driver) {
        connection.setDriver(driver);
        return this;
    }

    public JdbcConnectionBuilder withUrl(String url) {
        connection.setUrl(url);
        return this;
    }
}
