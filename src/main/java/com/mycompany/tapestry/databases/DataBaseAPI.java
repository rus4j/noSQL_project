package com.mycompany.tapestry.databases;

public interface DataBaseAPI <T>{

    public T executeQuery(String query);
}
