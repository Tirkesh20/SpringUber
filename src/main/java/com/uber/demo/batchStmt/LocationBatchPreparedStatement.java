package com.uber.demo.batchStmt;

import com.uber.demo.beans.Location;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocationBatchPreparedStatement implements BatchPreparedStatementSetter {
    private final Location location;

    public LocationBatchPreparedStatement(Location location) {
        this.location = location;
    }

    @Override
    public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setLong(1, location.getId());
        ps.setDouble(2,  location.getLat());
        ps.setDouble(3, (long) location.getLng());
        ps.setString(4, location.getReqStatus().toString());
        ps.setString(5, location.getFromTo().toString());
        ps.setLong(6, location.getAccount_id());
    }

    @Override
    public int getBatchSize() {
        return 6;
    }
}
