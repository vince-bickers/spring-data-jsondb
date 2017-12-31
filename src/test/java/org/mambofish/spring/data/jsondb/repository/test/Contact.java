package org.mambofish.spring.data.jsondb.repository.test;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

/**
 * @author vince
 */
@Document(collection = "contacts", schemaVersion = "1.0")
public class Contact {

    private @Id String id;
    private String name;

    public Contact() {}

    public Contact(String name) {
        this.id = name;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
