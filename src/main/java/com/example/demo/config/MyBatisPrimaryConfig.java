package com.example.demo.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(
  basePackages = {"com.example.demo.mapper"},
  annotationClass = Mapper.class)
public class MyBatisPrimaryConfig {

  @Bean
  @Primary
  public SqlSessionFactory sqlSessionFactory(
    DataSourceProperties primaryDataSourceProperties,
    MybatisAutoConfiguration mybatisAutoConfiguration
  ) throws Exception {
    final var dataSource = primaryDataSourceProperties.initializeDataSourceBuilder().build();
    return mybatisAutoConfiguration.sqlSessionFactory(dataSource);
  }
}
