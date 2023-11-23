package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ExampleServiceTest {

  @Autowired
  ExampleService exampleService;

  @Test
  void test() {
    assertThat(exampleService.getPrimaryDatabaseVersion()).startsWith("Microsoft SQL Server");
    assertThat(exampleService.getSecondaryDatabaseVersion()).startsWith("Oracle");
  }
}
