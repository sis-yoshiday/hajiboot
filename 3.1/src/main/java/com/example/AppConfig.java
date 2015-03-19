package com.example;

import javax.sql.DataSource;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuki_yoshida on 15/03/01.
 */
@Configuration
public class AppConfig {

  @Autowired DataSourceProperties dataSourceProperties;

  DataSource dataSource;

  @Bean(destroyMethod = "close")
  DataSource realDataSource() {

    DataSourceBuilder builder = DataSourceBuilder
        .create(dataSourceProperties.getClassLoader())
        .url(dataSourceProperties.getUrl())
        .username(dataSourceProperties.getUsername())
        .password(dataSourceProperties.getPassword());

    dataSource = builder.build();
    return dataSource;
  }

  @Bean
  DataSource dataSource() {
    return new Log4jdbcProxyDataSource(dataSource);
  }

}
