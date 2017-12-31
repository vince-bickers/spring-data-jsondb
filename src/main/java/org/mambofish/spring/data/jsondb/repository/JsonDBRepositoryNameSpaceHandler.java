package org.mambofish.spring.data.jsondb.repository;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.data.repository.config.RepositoryBeanDefinitionParser;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

public class JsonDBRepositoryNameSpaceHandler extends NamespaceHandlerSupport {

	public void init() {

		RepositoryConfigurationExtension extension = new JsonDBRepositoryConfigurationExtension();
		RepositoryBeanDefinitionParser repositoryBeanDefinitionParser = new RepositoryBeanDefinitionParser(extension);

		registerBeanDefinitionParser("repositories", repositoryBeanDefinitionParser);
	}
}
