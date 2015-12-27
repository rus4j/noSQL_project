package com.mycompany.tapestry.pages;

import com.datastax.driver.core.Row;
import com.mycompany.tapestry.databases.DataBaseAPI;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

public class Page <D extends DataBaseAPI, T, V>{
    @Property
    private String queryText;
    @Property
    private V qr;
    @Inject
    private Request request;
    @InjectComponent
    private Zone formZone;

    T result;
    D db;

    Object onSuccess() {
        return request.isXHR() ? formZone.getBody() : null;
    }

    public List<V> getQueryResult() {
        if (queryText != null) {
            result = (T) db.executeQuery(queryText);
        }
        return null;
    }

    @Property
    private final ValueEncoder<V> encoder = new ValueEncoder<V>() {
        @Override
        public String toClient(V value) {
            return String.valueOf(value.toString());
        }

        @Override
        public V toValue(String clientValue) {
            return null;
        }
    };

}
