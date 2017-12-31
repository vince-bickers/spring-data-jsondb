package org.mambofish.spring.data.jsondb.query;

import io.jsondb.JsonDBTemplate;
import org.springframework.data.repository.query.QueryMethod;
import org.springframework.data.repository.query.RepositoryQuery;

/**
 * @author vince
 */
public class JsonDBRepositoryQuery implements RepositoryQuery {

    private final JsonDBQueryMethod queryMethod;
    private final JsonDBTemplate template;

    public JsonDBRepositoryQuery(JsonDBQueryMethod queryMethod, JsonDBTemplate template) {
        this.queryMethod = queryMethod;
        this.template = template;
    }

    @Override
    public Object execute(Object[] objects) {

        return null;
        //return template.findAll()
    }

    @Override
    public QueryMethod getQueryMethod() {
        return queryMethod;
    }
}
