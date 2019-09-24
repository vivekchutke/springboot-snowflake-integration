package com.vivekchutke.snowflake.snowflakeservice;/*
 * Copyright (c) 2012, 2013 Snowflake Computing Inc. All rights reserved.
 *
 * - Download the latest version of the driver (snowflake-jdbc-<ver>.jar) from Maven:
 *       https://repo1.maven.org/maven2/net/snowflake/snowflake-jdbc/<ver>
 * - Download this file (SnowflakeJDBCExample.java) into the same directory. 
 * - Edit this file (SnowflakeJDBCExample.java) and set the connection properties correctly.
 * - From the command line, run:
 *     javac SnowflakeJDBCExample.java
 * - From the command line, run:
 *   - Linux/MacOS:
 *     java -cp .:snowflake-jdbc-<ver>.jar SnowflakeJDBCExample
 *   - Windows:
 *     java -cp .;snowflake-jdbc-<ver>.jar SnowflakeJDBCExample
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SnowflakeJDBCExample {

  public static void main(String[] args) throws Exception {
    // get connection
    System.out.println("Create JDBC connection");
    Connection connection = getConnection();
    System.out.println("Done creating JDBC connection\n");

    // create statement
    System.out.println("Create JDBC statement");
    Statement statement = connection.createStatement();
    System.out.println("Done creating JDBC statement\n");
//
//    // create a table
//    System.out.println("Create demo table");
//    statement.executeUpdate("create or replace table demo(c1 string)");
//    statement.close();
//    System.out.println("Done creating demo table\n");
//
//    // insert a row
//    System.out.println("Insert 'hello world'");
//    statement.executeUpdate("insert into demo values ('hello world')");
//    statement.close();
//    System.out.println("Done inserting 'hello world'\n");
//
//    // query the data
//    System.out.println("Query demo");
//    ResultSet resultSet = statement.executeQuery("select * from demo");
//    System.out.println("Metadata:");
//    System.out.println("================================");

    System.out.println("Query demo");
    ResultSet resultSet = statement.executeQuery("select * from CALL_CENTER");
    resultSet.getRow();
    System.out.println("Metadata:");
    System.out.println("================================");
    while(resultSet.next()) {
      System.out.print(" : "+resultSet.getString("CC_STREET_TYPE"));
      System.out.print(" : "+resultSet.getString("CC_SUITE_NUMBER"));
      System.out.print(" : "+resultSet.getString("CC_CITY"));
      System.out.print(" : "+resultSet.getString("CC_STATE"));
      System.out.print(" : "+resultSet.getString("CC_COUNTRY"));
      System.out.print(" : "+resultSet.getString("CC_GMT_OFFSET"));
      System.out.print(" :"+resultSet.getString("CC_TAX_PERCENTAGE"));
      System.out.println();
    }

    // fetch metadata
    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    System.out.println("Number of columns=" +
                       resultSetMetaData.getColumnCount());
    for (int colIdx = 0; colIdx < resultSetMetaData.getColumnCount();
         colIdx++) {
      System.out.println("Column " + colIdx + ": type=" +
                         resultSetMetaData.getColumnTypeName(colIdx + 1));
    }

    // fetch data
    System.out.println("\nData:");
    System.out.println("================================");
    int rowIdx = 0;
    while (resultSet.next()) {
      System.out.println("row " + rowIdx + ", column 0: " +
                         resultSet.getString(1));
    }
    resultSet.close();
    statement.close();
    connection.close();
  }


  private static Connection getConnection()
      throws SQLException {
    try {
      Class.forName("net.snowflake.client.jdbc.SnowflakeDriver");
    } catch (ClassNotFoundException ex) {
      System.err.println("Driver not found");
    }

    //https://kj22564.canada-central.azure.snowflakecomputing.com/console#/account/users
    // jdbc:snowflake://<account_name>.<region_id>.snowflakecomputing.com
    // jdbc:snowflake://kj22564.canada-central.azure.snowflakecomputing.com
    // build connection properties
    Properties properties = new Properties();
    properties.put("user", "vivekchutke");        // replace "" with your user name
    properties.put("password", "Snowflake@24viv");    // replace "" with your password
    properties.put("account", "kj22564");     // replace "" with your account name
    properties.put("warehouse", "COMPUTE_WH");   // replace "" with target warehouse name
    properties.put("db", "SNOWFLAKE_SAMPLE_DATA");  // replace "" with target database name
    properties.put("schema", "TPCDS_SF100TCL");      // replace "" with target schema name
//    properties.put("tracing", "on"); // optional tracing property

    // replace <account_name> with the name of your account, as provided by Snowflake
    // replace <region_id> with the name of the region where your account is located (if not US West)
    // remove region ID segment (not needed) if your account is located in US West
    String connectStr = "jdbc:snowflake://kj22564.canada-central.azure.snowflakecomputing.com";
    return DriverManager.getConnection(connectStr, properties);
  }
}

