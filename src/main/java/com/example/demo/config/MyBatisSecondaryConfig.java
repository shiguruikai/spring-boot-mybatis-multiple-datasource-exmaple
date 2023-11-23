package com.example.demo.config;

import com.example.demo.annotations.SecondaryMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
  basePackages = {"com.example.demo.mapper"},
  annotationClass = SecondaryMapper.class,
  sqlSessionFactoryRef = MyBatisSecondaryConfig.SQL_SESSION_FACTORY_NAME)
public class MyBatisSecondaryConfig {
  public static final String SQL_SESSION_FACTORY_NAME = "secondarySqlSessionFactory";

  @Bean(SQL_SESSION_FACTORY_NAME)
  public SqlSessionFactory sqlSessionFactory(
    @Qualifier(DataSourcePropertiesConfiguration.SECONDARY_DATA_SOURCE_PROPERTIES_NAME)
    DataSourceProperties dataSourceProperties,
    MybatisAutoConfiguration mybatisAutoConfiguration
  ) throws Exception {
    final var dataSource = dataSourceProperties.initializeDataSourceBuilder().build();
    return mybatisAutoConfiguration.sqlSessionFactory(dataSource);
  }
}
