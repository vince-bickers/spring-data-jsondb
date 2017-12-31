package org.mambofish.spring.data.jsondb.repository;

import java.lang.annotation.Annotation;

import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

/**
 * @author vince
 */
public class JsonDBRepositoriesRegistrar extends RepositoryBeanDefinitionRegistrarSupport {

	@Override
	protected Class<? extends Annotation> getAnnotation() {
		return EnableJsonDBRepositories.class;
	}

	@Override
	protected RepositoryConfigurationExtension getExtension() {
		return new JsonDBRepositoryConfigurationExtension();
	}
}
