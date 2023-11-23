package com.example.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourcePropertiesConfiguration {

  public static final String SECONDARY_DATA_SOURCE_PROPERTIES_NAME = "secondaryDataSourceProperties";

  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource")
  public DataSourceProperties dataSourceProperties() {
    return new DataSourceProperties();
  }

  @Bean(SECONDARY_DATA_SOURCE_PROPERTIES_NAME)
  @ConfigurationProperties("app.secondary-datasource")
  public DataSourceProperties secondaryDataSourceProperties() {
    return new DataSourceProperties();
  }
}
