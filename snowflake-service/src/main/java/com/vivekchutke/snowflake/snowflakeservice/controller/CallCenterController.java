package com.vivekchutke.snowflake.snowflakeservice.controller;

import com.vivekchutke.snowflake.snowflakeservice.connection.SnowflakeConnection;
import com.vivekchutke.snowflake.snowflakeservice.model.CallCenter;
import com.vivekchutke.snowflake.snowflakeservice.repository.CallCenterRepository;
import com.vivekchutke.snowflake.snowflakeservice.service.CallCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CallCenterController {
    @Autowired
    private CallCenterService callCenterService;

    @Autowired
    private CallCenterRepository callCenterRepository;


    @GetMapping("/callcenter")
    public List<CallCenter> retrieveAllCallCenter() throws SQLException {
        return callCenterService.retrieveAllCenterRows();
    }

    @GetMapping("/callcenter-template")
    public List<CallCenter> retrieveAllCallCenter_template() throws SQLException {
        return callCenterRepository.retrieveCallCenter();
    }
}
