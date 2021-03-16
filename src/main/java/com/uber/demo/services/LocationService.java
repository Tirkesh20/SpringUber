package com.uber.demo.services;


import com.uber.demo.beans.Location;
import com.uber.demo.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService extends ServiceInterface<Location>{
    private  final LocationDao locationDao;

    @Autowired
    public LocationService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public List<Location> readAll(){
        return locationDao.getAllLocations();
    }

    public Location read(long id){
        return locationDao.getLocation(id);
    }

    @Override
    public Location update(long id) {
        return locationDao.updateLocation(id);
    }

    public Location create(Location entity){
        return locationDao.save(entity);
    }

    @Override
    public Location delete(long id) {
        return locationDao.deleteLocation(id);
    }
}

