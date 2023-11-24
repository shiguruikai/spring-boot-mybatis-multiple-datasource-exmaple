## Multiple datasource usage example with MyBatis in Spring Boot

「Spring Boot + MyBatis」で複数のデータソースを使用するサンプルコード。

### 内容

- [application.yml](/src/main/resources/application.yml) にデータソースを2つ定義する。
  - `spring.datasource`
  - `spring.datasource2`
- [DataSourcePropertiesConfiguration.java](/src/main/java/com/example/demo/config/DataSourcePropertiesConfiguration.java) で2つのデータソースのプロパティをBeanに登録する。
- `@MapperScan` を使用して、2つのデータソースをアノテーション `@Mapper`, `@SecondaryMapper` で使い分けられるようにする。
  - [MyBatisPrimaryConfig.java](/src/main/java/com/example/demo/config/MyBatisPrimaryConfig.java)
  - [MyBatisSecondaryConfig.java](/src/main/java/com/example/demo/config/MyBatisSecondaryConfig.java)
  - [SecondaryMapper.java](/src/main/java/com/example/demo/annotations/SecondaryMapper.java)
- テストコード [DaoTest.java](/src/test/java/com/example/demo/DaoTest.java) にて、以下をテストする。
  - [PrimaryDao.java](/src/main/java/com/example/demo/mapper/PrimaryDao.java) ([PrimaryDao.xml](/src/main/resources/com/example/demo/mapper/PrimaryDao.xml))
    は `spring.datasource`
    のデータソース（SQL Server）で実行される。
  - [SecondaryDao.java](/src/main/java/com/example/demo/mapper/SecondaryDao.java) ([SecondaryDao.xml](/src/main/resources/com/example/demo/mapper/SecondaryDao.xml))
    は `spring.datasource2`
    のデータソース（Oracle）で実行される。
