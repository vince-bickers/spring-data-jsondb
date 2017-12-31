package org.mambofish.spring.data.jsondb.repository;

import java.io.Serializable;

import org.springframework.data.repository.core.support.AbstractEntityInformation;

/**
 * @author vince
 */
public class JsonDBEntityInformation<ID extends Serializable, T> extends AbstractEntityInformation<T, String> {

    public JsonDBEntityInformation(Class<T> domainClass) {
        super(domainClass);
    }

    @Override
    public String getId(T t) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public Class<String> getIdType() {
        return String.class;
    }


}
