package com.vivekchutke.snowflake.snowflakeservice.connection;

import net.snowflake.client.jdbc.SnowflakeBasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.lang.reflect.InvocationTargetException;

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("classpath:snowflakejdbc.properties")
public class SnowflakeJDBCConnector {

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(SnowflakeBasicDataSource dataSource)
    {
        System.out.println("*******in JDBC Template");
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(SnowflakeBasicDataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    protected SnowflakeBasicDataSource dataSource() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("*******@@@@@@@@@@@@@");
        SnowflakeBasicDataSource dataSource = new SnowflakeBasicDataSource();
        dataSource.setUrl(environment.getProperty("datasource_url"));
        dataSource.setUser(environment.getProperty("datasource.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        dataSource.setWarehouse(environment.getProperty("datasource.warehouse"));
        dataSource.setDatabaseName(environment.getProperty("datasource.database"));
        dataSource.setSchema(environment.getProperty("datasource.schema"));
        dataSource.setAccount(environment.getProperty("datasource.account"));
//        dataSource.setDriverClassName();
        return dataSource;
    }

//    @Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource)
//    {
//        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
//        dataSourceInitializer.setDataSource(dataSource);
//        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
//        databasePopulator.addScript(new ClassPathResource("data.sql"));
//        dataSourceInitializer.setDatabasePopulator(databasePopulator);
//        dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
//        return dataSourceInitializer;
//    }

}
