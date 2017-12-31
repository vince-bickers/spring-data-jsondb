package org.mambofish.spring.data.jsondb.repository.test;

import io.jsondb.JsonDBTemplate;
import org.mambofish.spring.data.jsondb.repository.EnableJsonDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vince
 */
@Configuration
@EnableJsonDBRepositories
public class JsonDBRepositoryConfig {

    @Bean
    public JsonDBTemplate jsonDBTemplate() {

        return new JsonDBTemplate("target/testdb", "org.mambofish.spring.data.jsondb.repository.test");
    }
}
