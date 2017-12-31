package org.mambofish.spring.data.jsondb.query;

import java.lang.reflect.Method;

import io.jsondb.JsonDBTemplate;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.NamedQueries;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.data.repository.query.RepositoryQuery;

/**
 * @author vince
 */
public class JsonDBQueryLookupStrategy implements QueryLookupStrategy {

    private final JsonDBTemplate template;

    public JsonDBQueryLookupStrategy(JsonDBTemplate template) {
        this.template = template;
    }


    @Override
    public RepositoryQuery resolveQuery(Method method, RepositoryMetadata metadata, ProjectionFactory factory, NamedQueries namedQueries) {
        JsonDBQueryMethod queryMethod = new JsonDBQueryMethod(method, metadata, factory, template);
        return new JsonDBRepositoryQuery(queryMethod, template);
    }
}
