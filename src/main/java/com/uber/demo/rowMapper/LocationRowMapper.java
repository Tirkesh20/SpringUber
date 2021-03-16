package com.uber.demo.rowMapper;

import com.uber.demo.beans.Location;
import com.uber.demo.enums.FromTo;
import com.uber.demo.enums.ReqStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationRowMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet resultSet, int i) throws SQLException {
        final  Location location=new Location();
        location.setId(resultSet.getLong("id"));
        location.setLat(resultSet.getLong("lat"));
        location.setLng(resultSet.getLong("lng"));
        location.setReqStatus(ReqStatus.valueOf(resultSet.getString("req_status")));
        location.setFromTo(FromTo.valueOf(resultSet.getString("place")));
        location.setAccountId(resultSet.getLong("account_id"));
        return location;
    }
}
