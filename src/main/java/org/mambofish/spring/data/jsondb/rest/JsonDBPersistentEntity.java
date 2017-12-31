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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.PersistentProperty;
import org.springframework.data.mapping.model.BasicPersistentEntity;
import org.springframework.data.util.TypeInformation;

/**
 * @author vince
 */
public class JsonDBPersistentEntity<T> extends BasicPersistentEntity<T, JsonDBPersistentProperty> {

    private static final Logger logger = LoggerFactory.getLogger(JsonDBPersistentEntity.class);

    /**
     * Constructs a new {@link JsonDBPersistentEntity} based on the given type information.
     *
     * @param information The {@link TypeInformation} upon which to base this persistent entity.
     */
    public JsonDBPersistentEntity(TypeInformation<T> information) {
        super(information);
    }

    @Override
    public boolean hasVersionProperty() {
        logger.debug("[entity].hasVersionProperty() returns false"); // by design
        return false;
    }

    @Override
    public JsonDBPersistentProperty getVersionProperty() {
        logger.debug("[entity].getVersionProperty() returns null"); // by design
        return null;
    }

    @Override
    public boolean isVersionProperty(PersistentProperty<?> property) {
        logger.debug("[entity].isIdProperty({}) returns false", property); // again, by design
        return false;
    }

}
