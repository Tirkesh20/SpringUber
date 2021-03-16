package com.uber.demo.controller;

import com.uber.demo.beans.Location;
import com.uber.demo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService= locationService;
    }
    @GetMapping("/location/read/{id}")
    public Location read(@PathVariable("id")Long id){
        return locationService.read(id);
    }
    @PostMapping("/location/Create")
    public Location create(@Valid Location locations){
        return locationService.create(locations);
    }
    @GetMapping("/location/readAll/all")
    public List<Location> readAll(){
        return locationService.readAll();
    }
    @PatchMapping("/location/update/{id}")
    public Location update(@PathVariable("id") Long id) {
        return locationService.update(id);
    }
    @DeleteMapping("/location/delete/{id}")
    public Location delete(@PathVariable("id")Long id) {
        return locationService.delete(id);
    }

}
