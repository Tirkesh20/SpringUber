package com.uber.demo.dao;

import com.uber.demo.batchStmt.LocationBatchPreparedStatement;
import com.uber.demo.beans.Location;
import com.uber.demo.preparedStmtCallBack.LocationCallBack;
import com.uber.demo.rowMapper.LocationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import org.springframework.stereotype.Component;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LocationDao {
    public final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Autowired
    public LocationDao(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }

    public int getCountOfAccount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM location", Integer.class);
    }

    public List<Location> getAllLocations() {
        return jdbcTemplate.query("SELECT * FROM location", new LocationRowMapper());
    }

    public Location save(Location locations) {
        String query = "insert into location values (:id,:lat,:lng,:req_status,:place)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", locations.getId());
        parameters.put("lat", locations.getLat());
        parameters.put("lng",locations.getLng());
        parameters.put("req_status" ,locations.getReqStatus());
        parameters.put("place",locations.getFromTo());
        namedParameterJdbcTemplate.execute(query, parameters, new LocationCallBack());
        return locations;
    }

    public Location getLocation(final long id) {
        final String query = "SELECT * FROM location WHERE ID = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new LocationRowMapper());
    }
    public Location deleteLocation(long id){
        Location locations=getLocation(id);
        String SQL = "delete from location where id = ?";
        jdbcTemplate.update(SQL, id);
        return locations;
    }
    public String getEmployeeUsingMapSqlParameterSource() {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
        return namedParameterJdbcTemplate.queryForObject("SELECT account_id FROM location WHERE ID = :id", namedParameters, String.class);
    }

    public Location updateLocation(long id) {
        Location locations=getLocation(id);
        jdbcTemplate.batchUpdate("INSERT INTO location VALUES (?, ?, ?, ? ,? ,?)", new LocationBatchPreparedStatement(locations));
        return locations;
    }
}
