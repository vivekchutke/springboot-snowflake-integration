package com.vivekchutke.snowflake.snowflakeservice.repository;

import com.vivekchutke.snowflake.snowflakeservice.model.CallCenter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CallCenterRowMapper implements RowMapper<CallCenter> {

    @Override
    public CallCenter mapRow(ResultSet resultSet, int i) throws SQLException {
        CallCenter callCenter = new CallCenter();
        callCenter.setCC_STREET_TYPE(resultSet.getString("CC_STREET_TYPE"));
        callCenter.setCC_SUITE_NUMBER(resultSet.getString("CC_SUITE_NUMBER"));
        callCenter.setCC_CITY(resultSet.getString("CC_CITY"));
        callCenter.setCC_STATE(resultSet.getString("CC_STATE"));
        callCenter.setCC_COUNTY(resultSet.getString("CC_COUNTRY"));
        callCenter.setCC_GMT_OFFSET(resultSet.getString("CC_GMT_OFFSET"));
        callCenter.setCC_TAX_PERCENTAGE(resultSet.getString("CC_TAX_PERCENTAGE"));
        return callCenter;
    }
}
