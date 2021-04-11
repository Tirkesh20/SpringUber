package com.uber.demo.beans;

import com.uber.demo.enums.FromTo;
import com.uber.demo.enums.ReqStatus;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class Location {
    private long id;
    private double lat;
    private double lng;
    private FromTo fromTo;
    private ReqStatus reqStatus = ReqStatus.WAITING;
    private long account_id;

    public long getAccount_id() {
        return account_id;
    }

    public void setAccountId(long account_id) {
        this.account_id = account_id;
    }

    public ReqStatus getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(ReqStatus reqStatus) {
        this.reqStatus = reqStatus;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public double getLng() {
        return lng;
    }
    public double getLat(){
        return lat;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }

    public FromTo getFromTo() {
        return fromTo;
    }
    public void setFromTo(FromTo fromTo) {
        this.fromTo = fromTo;
    }

}