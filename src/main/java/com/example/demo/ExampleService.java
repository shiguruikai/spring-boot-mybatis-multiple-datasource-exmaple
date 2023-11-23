package com.example.demo;

import com.example.demo.mapper.PrimaryDao;
import com.example.demo.mapper.SecondaryDao;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
  private final PrimaryDao primaryDao;
  private final SecondaryDao secondaryDao;

  public ExampleService(PrimaryDao primaryDao, SecondaryDao secondaryDao) {
    this.primaryDao = primaryDao;
    this.secondaryDao = secondaryDao;
  }

  public String getPrimaryDatabaseVersion() {
    return primaryDao.getDatabaseVersion();
  }

  public String getSecondaryDatabaseVersion() {
    return secondaryDao.getDatabaseVersion();
  }
}
