package br.com.bradesco.pfiningestion.config;

import javax.sql.DataSource;

public interface DataSourceConfig {
    DataSource appDataSource();
    DataSource pfinDataSource();
}
