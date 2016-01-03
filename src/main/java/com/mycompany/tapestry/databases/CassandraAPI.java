package com.mycompany.tapestry.databases;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraAPI <ResultSet> implements DataBaseAPI{

    Cluster cluster;
    Session session;

    public CassandraAPI() {
        cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        session = cluster.connect("users");
    }

    @Override
    public ResultSet executeQuery(String query) {
        return (ResultSet) session.execute(query);
    }

}
