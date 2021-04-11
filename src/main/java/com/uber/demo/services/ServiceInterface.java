package com.uber.demo.services;

import com.uber.demo.beans.Account;

import java.util.List;

public abstract class ServiceInterface<T> {
    public abstract T create( T entity);

    public abstract T delete(long id);

    public abstract List<T> readAll();

    public abstract T read(long id);

    public abstract T update(long id);


    public List<T> readClient(long id)   {
        return null;
    }

    public List<T> readTaxi() {
        return null;
    }

    public T checkService(String username,String password){
        return null;
    }

    public Account returnTaxi(){
        return null;
    }

}
