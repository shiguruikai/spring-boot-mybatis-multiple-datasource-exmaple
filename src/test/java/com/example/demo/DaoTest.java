package com.example.demo;

import com.example.demo.mapper.PrimaryDao;
import com.example.demo.mapper.SecondaryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DaoTest {

  @Autowired
  PrimaryDao primaryDao;

  @Autowired
  SecondaryDao secondaryDao;

  @Test
  void test() {
    assertThat(primaryDao.getDatabaseVersion()).startsWith("Microsoft SQL Server");
    assertThat(secondaryDao.getDatabaseVersion()).startsWith("Oracle");
  }
}
