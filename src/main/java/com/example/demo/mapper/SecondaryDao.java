package com.example.demo.mapper;

import com.example.demo.annotations.SecondaryMapper;

@SecondaryMapper
public interface SecondaryDao {
  String getDatabaseVersion();
}
