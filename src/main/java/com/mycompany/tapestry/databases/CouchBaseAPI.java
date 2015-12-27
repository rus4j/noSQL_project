package com.mycompany.tapestry.databases;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.view.ViewQuery;
import com.couchbase.client.java.view.ViewResult;

public class CouchBaseAPI<ViewResult> implements DataBaseAPI {

    Cluster cluster;
    Bucket bucket;

    public CouchBaseAPI() {
        cluster = CouchbaseCluster.create();
        bucket = cluster.openBucket("userts");
    }

    @Override
    public com.couchbase.client.java.view.ViewResult executeQuery(String query) {
        //com.couchbase.client.java.document.JsonDocument j = bucket.get(query); 
        com.couchbase.client.java.view.ViewResult res = bucket.query(ViewQuery.from(query, "qwer"));        
        //System.out.println("zzzzzzzzzzzzzz "+ res.allRows().get(0).document().content().getString("name"));
        return res;
    }
}
