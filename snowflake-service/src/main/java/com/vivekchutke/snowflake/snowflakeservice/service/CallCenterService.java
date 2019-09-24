package com.vivekchutke.snowflake.snowflakeservice.service;

import com.vivekchutke.snowflake.snowflakeservice.connection.SnowflakeConnection;
import com.vivekchutke.snowflake.snowflakeservice.model.CallCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CallCenterService {

    @Autowired
    private SnowflakeConnection snowflakeConnection;

    public List<CallCenter> retrieveAllCenterRows() throws SQLException {

        List<CallCenter> callCenters = new ArrayList<>();
        System.out.println("Create JDBC connection");
        Connection connection = snowflakeConnection.getConnection();
        System.out.println("Done creating JDBC connection\n");

        // create statement
        System.out.println("Create JDBC statement");
        Statement statement = connection.createStatement();
        System.out.println("Done creating JDBC statement\n");
        System.out.println("Query demo");
        ResultSet resultSet = statement.executeQuery("select * from CALL_CENTER");
        resultSet.getRow();
        System.out.println("Metadata:");
        System.out.println("================================");
        while (resultSet.next()) {
            CallCenter callCenter = new CallCenter();
            callCenter.setCC_STREET_TYPE(resultSet.getString("CC_STREET_TYPE"));
            callCenter.setCC_SUITE_NUMBER(resultSet.getString("CC_SUITE_NUMBER"));
            callCenter.setCC_CITY(resultSet.getString("CC_CITY"));
            callCenter.setCC_STATE(resultSet.getString("CC_STATE"));
            callCenter.setCC_COUNTY(resultSet.getString("CC_COUNTRY"));
            callCenter.setCC_GMT_OFFSET(resultSet.getString("CC_GMT_OFFSET"));
            callCenter.setCC_TAX_PERCENTAGE(resultSet.getString("CC_TAX_PERCENTAGE"));
            callCenters.add(callCenter);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return callCenters;
    }
}
