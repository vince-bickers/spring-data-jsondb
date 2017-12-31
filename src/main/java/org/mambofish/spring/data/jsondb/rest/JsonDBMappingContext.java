/*
 * Copyright (c)  [2011-2017] "Pivotal Software, Inc." / "Neo Technology" / "Graph Aware Ltd."
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 * conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 */
package org.mambofish.spring.data.jsondb.rest;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.context.AbstractMappingContext;
import org.springframework.data.mapping.model.SimpleTypeHolder;
import org.springframework.data.util.TypeInformation;

/**
 * @author vince
 */
public class JsonDBMappingContext extends AbstractMappingContext<JsonDBPersistentEntity<?>, JsonDBPersistentProperty> {

    private static final Logger logger = LoggerFactory.getLogger(JsonDBMappingContext.class);

    public JsonDBMappingContext() {
    }

    @Override
    protected <T> JsonDBPersistentEntity<?> createPersistentEntity(TypeInformation<T> typeInformation) {
        return new JsonDBPersistentEntity<>(typeInformation);
    }

    @Override
    protected JsonDBPersistentProperty createPersistentProperty(Field field, PropertyDescriptor propertyDescriptor, JsonDBPersistentEntity<?> jsonDBPersistentEntity, SimpleTypeHolder simpleTypeHolder) {
        return new JsonDBPersistentProperty(field, propertyDescriptor, jsonDBPersistentEntity, simpleTypeHolder);
    }
}
