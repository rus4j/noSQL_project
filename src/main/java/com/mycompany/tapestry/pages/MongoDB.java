package com.mycompany.tapestry.pages;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mycompany.tapestry.databases.MongoDBAPI;
import java.util.LinkedList;
import java.util.List;

public class MongoDB extends Page<MongoDBAPI, DBCursor, DBObject> {

    public MongoDB(){
        db = new MongoDBAPI();
    }
    
    @Override
    public List<DBObject> getQueryResult() {
        super.getQueryResult();
        List<DBObject> list = new LinkedList<DBObject>();
        if (result != null) {
//            while(result.hasNext()){
//                list.add(result.next());
//            }
            return result.toArray();
        } else {
            return null;
        }
    }

}
