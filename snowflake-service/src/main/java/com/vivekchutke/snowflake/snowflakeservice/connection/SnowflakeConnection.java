package com.vivekchutke.snowflake.snowflakeservice.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:snowflakejdbc.properties")
public class SnowflakeConnection {

    @Autowired
    private Environment environment;

    public SnowflakeConnection() {

    }

//    spring.datasource.driver-class-name=net.snowflake.client.jdbc.SnowflakeDriver
//    spring.datasource.url=jdbc:snowflake://kj22564.canada-central.azure.snowflakecomputing.com
//    spring.datasource.username=vivekchutke
//    spring.datasource.password=Snowflake@24viv
//    spring.datasource.account=kj22564
//    spring.datasource.warehouse=COMPUTE_WH
//    spring.datasource.database=SNOWFLAKE_SAMPLE_DATA
//    spring.datasource.schema=TPCDS_SF100TCL
    public  Connection getConnection()
            throws SQLException {
        try {
            Class.forName(environment.getProperty("datasource.driver-class-name"));
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver not found");
        }

        //https://kj22564.canada-central.azure.snowflakecomputing.com/console#/account/users
        // jdbc:snowflake://<account_name>.<region_id>.snowflakecomputing.com
        // jdbc:snowflake://kj22564.canada-central.azure.snowflakecomputing.com
        // build connection properties
        Properties properties = new Properties();

        properties.put("user", environment.getProperty("datasource.username"));        // replace "" with your user name
        properties.put("password", environment.getProperty("datasource.password"));    // replace "" with your password
        properties.put("account", environment.getProperty("datasource.account"));     // replace "" with your account name
        properties.put("warehouse", environment.getProperty("datasource.warehouse"));   // replace "" with target warehouse name
        properties.put("db", environment.getProperty("datasource.database"));  // replace "" with target database name
        properties.put("schema", environment.getProperty("datasource.schema"));

//        properties.put("user", "vivekchutke");        // replace "" with your user name
//        properties.put("password", "Snowflake@24viv");    // replace "" with your password
//        properties.put("account", "kj22564");     // replace "" with your account name
//        properties.put("warehouse", "COMPUTE_WH");   // replace "" with target warehouse name
//        properties.put("db", "SNOWFLAKE_SAMPLE_DATA");  // replace "" with target database name
//        properties.put("schema", "TPCDS_SF100TCL");      // replace "" with target schema name
//    properties.put("tracing", "on"); // optional tracing property

        // replace <account_name> with the name of your account, as provided by Snowflake
        // replace <region_id> with the name of the region where your account is located (if not US West)
        // remove region ID segment (not needed) if your account is located in US West
        String connectStr = environment.getProperty("datasource_url");
        return DriverManager.getConnection(connectStr, properties);
    }
}
