package com.mycompany.tapestry.databases;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBAPI<DBCursor> implements DataBaseAPI{

    MongoClient mongoClient;
    DB db;
    //MongoDatabase db2;
    
    public MongoDBAPI() {
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDB("users");
        //db2 = mongoClient.getDatabase("users");
    }

    @Override
    public DBCursor executeQuery(String query) {
        DBCollection coll = db.getCollection(query);
        return (DBCursor) coll.find();
    }
    
}
