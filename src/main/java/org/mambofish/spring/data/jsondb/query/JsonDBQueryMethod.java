package org.mambofish.spring.data.jsondb.query;

import java.lang.reflect.Method;

import io.jsondb.JsonDBTemplate;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryMethod;

/**
 * @author vince
 */
public class JsonDBQueryMethod extends QueryMethod {

    private final JsonDBTemplate template;
    private final Method method;

    public JsonDBQueryMethod(Method method, RepositoryMetadata metadata, ProjectionFactory factory, JsonDBTemplate template) {
        super(method, metadata, factory);
        this.method = method;
        this.template = template;
    }

}
