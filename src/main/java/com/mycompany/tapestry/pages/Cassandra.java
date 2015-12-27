package com.mycompany.tapestry.pages;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.mycompany.tapestry.databases.CassandraAPI;
import java.util.List;

public class Cassandra extends Page<CassandraAPI, ResultSet, Row> {

    public Cassandra() {
        db = new CassandraAPI();
    }

    @Override
    public List<Row> getQueryResult() {
        super.getQueryResult();
        if (result != null) {
            //result.all().get(0).getString("name");
            return result.all();
        } else {
            return null;
        }
    }
}
