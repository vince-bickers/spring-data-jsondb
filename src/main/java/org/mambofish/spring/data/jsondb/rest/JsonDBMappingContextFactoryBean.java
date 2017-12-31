package org.mambofish.spring.data.jsondb.rest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author vince
 */
public class JsonDBMappingContextFactoryBean extends AbstractFactoryBean<JsonDBMappingContext> implements ApplicationContextAware {

    private ListableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.beanFactory = applicationContext;
    }

    @Override
    public Class<?> getObjectType() {
        return JsonDBMappingContext.class;
    }

    @Override
    protected JsonDBMappingContext createInstance() throws Exception {

        JsonDBMappingContext context = new JsonDBMappingContext();
        context.initialize();

        return context;
    }
}
