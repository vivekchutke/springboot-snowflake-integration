package com.vivekchutke.snowflake.snowflakeservice.repository;

import com.vivekchutke.snowflake.snowflakeservice.model.CallCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CallCenterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public List<CallCenter> retrieveCallCenter() {
        List<CallCenter> callCenters = new ArrayList<>();
        return jdbcTemplate.query("select * from CALL_CENTER", new CallCenterRowMapper());
    }
}
