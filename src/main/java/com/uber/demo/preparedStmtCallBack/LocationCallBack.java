package com.uber.demo.preparedStmtCallBack;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LocationCallBack implements PreparedStatementCallback<Integer> {

    @Override
    public Integer doInPreparedStatement(PreparedStatement query) throws SQLException, DataAccessException {
        return query.executeUpdate();
    }
}