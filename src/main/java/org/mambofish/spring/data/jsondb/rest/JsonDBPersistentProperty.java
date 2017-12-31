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

import io.jsondb.annotation.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.Association;
import org.springframework.data.mapping.model.AnnotationBasedPersistentProperty;
import org.springframework.data.mapping.model.SimpleTypeHolder;

/**
 * @author vince
 */
public class JsonDBPersistentProperty extends AnnotationBasedPersistentProperty<JsonDBPersistentProperty> {

	private static final Logger logger = LoggerFactory.getLogger(JsonDBPersistentProperty.class);

    public JsonDBPersistentProperty(Field field, PropertyDescriptor propertyDescriptor, JsonDBPersistentEntity<?> jsonDBPersistentEntity, SimpleTypeHolder typeHolder) {
        super(field, propertyDescriptor, jsonDBPersistentEntity, typeHolder);
    }

	@Override
	public boolean isIdProperty() {
		return isAnnotationPresent(Id.class);
	}

	@Override
	public boolean isVersionProperty() {
		logger.debug("[property].isVersionProperty() returns false"); // by design
		return false;
	}

	/**
	 * Overridden to force field access as opposed to getter method access for simplicity.
	 *
	 * @see org.springframework.data.mapping.model.AnnotationBasedPersistentProperty#usePropertyAccess()
	 */
	@Override
	public boolean usePropertyAccess() {
		logger.debug("[property].usePropertyAccess() returns false");
		return false;
	}

	@Override
	public boolean isAssociation() {
        logger.debug("[property].isAssociation() returns false");
        return false;
	}

	@Override
	protected Association<JsonDBPersistentProperty> createAssociation() {
		return new Association<>(this, null);
	}
}
