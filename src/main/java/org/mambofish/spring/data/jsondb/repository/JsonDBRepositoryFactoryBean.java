package org.mambofish.spring.data.jsondb.repository;

import io.jsondb.JsonDBTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.core.support.TransactionalRepositoryFactoryBeanSupport;
import org.springframework.util.Assert;

/**
 * @author vince
 */
public class JsonDBRepositoryFactoryBean<T extends Repository<S, String>, S> extends TransactionalRepositoryFactoryBeanSupport<T, S, String> {

    private JsonDBTemplate template;

    @Autowired
    public void setTemplate(JsonDBTemplate template) {
        this.template = template;
    }

    @Override
    public void setMappingContext(MappingContext<?, ?> mappingContext) {
        super.setMappingContext(mappingContext);
    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(template, "Template must not be null!");
        super.afterPropertiesSet();
    }

    @Override
    protected RepositoryFactorySupport doCreateRepositoryFactory() {
        return createRepositoryFactory(template);
    }

    protected RepositoryFactorySupport createRepositoryFactory(JsonDBTemplate template) {
        return new JsonDBRepositoryFactory(template);
    }

}
