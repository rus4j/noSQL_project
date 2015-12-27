package com.mycompany.tapestry.pages;

import com.couchbase.client.java.view.ViewResult;
import com.couchbase.client.java.view.ViewRow;
import com.mycompany.tapestry.databases.CouchBaseAPI;
import java.util.LinkedList;
import java.util.List;

public class CouchBase extends Page<CouchBaseAPI, ViewResult, ViewRow> {

    public CouchBase() {
        db = new CouchBaseAPI();
    }

    @Override
    public List<ViewRow> getQueryResult() {
        super.getQueryResult();
        List<ViewRow> list = new LinkedList<ViewRow>();
        if (result != null) {
            for (ViewRow row : result.allRows()) {
                list.add(row);
            }
            return list;
//            JsonObject content = result.content();
//            list.add(content);
//            return list;
        }else 
            return null;
    }
}
