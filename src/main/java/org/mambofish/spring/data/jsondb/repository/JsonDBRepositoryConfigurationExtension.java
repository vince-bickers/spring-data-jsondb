package org.mambofish.spring.data.jsondb.repository;

import java.util.Collection;
import java.util.Collections;

import org.mambofish.spring.data.jsondb.rest.JsonDBMappingContextFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.repository.config.RepositoryConfigurationExtensionSupport;
import org.springframework.data.repository.config.RepositoryConfigurationSource;

/**
 * @author vince
 */
public class JsonDBRepositoryConfigurationExtension extends RepositoryConfigurationExtensionSupport {

    @Override
    protected String getModulePrefix() {
        return "json";
    }

    @Override
    public String getRepositoryFactoryClassName() {
        return JsonDBRepositoryFactoryBean.class.getName();
    }

    @Override
    protected Collection<Class<?>> getIdentifyingTypes() {
        return Collections.<Class<?>>singleton(JsonDBRepository.class);
    }

    @Override
    public void postProcess(BeanDefinitionBuilder builder, RepositoryConfigurationSource source) {
        builder.addPropertyReference("mappingContext","jsonMappingContext");
    }

    @Override
    public void registerBeansForRoot(BeanDefinitionRegistry registry, RepositoryConfigurationSource config) {

        super.registerBeansForRoot(registry, config);

        Object source = config.getSource();

        registerIfNotAlreadyRegistered(new RootBeanDefinition(JsonDBMappingContextFactoryBean.class), registry,
                "jsonMappingContext", source);
    }
}
