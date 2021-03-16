package com.uber.demo.preparedStmtCallBack;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrderCallBack implements PreparedStatementCallback<Integer> {
    @Override
    public Integer doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
        return preparedStatement.executeUpdate();
    }
}