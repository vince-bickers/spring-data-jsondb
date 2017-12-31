package org.mambofish.spring.data.jsondb.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.jsondb.JsonDBTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

/**
 * @author vince
 */

@Repository
public class JsonDBRepositoryImpl<T, ID extends Serializable> implements JsonDBRepository<T, ID> {

    private final JsonDBTemplate template;
    private final Class<T> clazz;

    public JsonDBRepositoryImpl(Class<T> domainClass, JsonDBTemplate template) {
        this.clazz = domainClass;
        this.template = template;
    }

    @Override
    public <S extends T> S save(S s) {
        if (!template.collectionExists(s.getClass())) {
            template.createCollection(s.getClass());
        }
        template.upsert(s);
        return s;
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> iterable) {
        iterable.forEach(S -> save(S));
        return iterable;
    }

    @Override
    public T findOne(ID id) {
        return template.findById(id, clazz);
    }

    @Override
    public boolean exists(ID id) {
        return findOne(id) != null;
    }

    @Override
    public Iterable<T> findAll() {
        return template.findAll(clazz);
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> iterable) {
        List<T> results = new ArrayList();
        iterable.forEach(ID -> {
            T o = findOne(ID);
            if (o != null) {
                results.add(o);
            }
        });
        return results;
    }

    @Override
    public long count() {
        return template.findAll(clazz).size();
    }

    @Override
    public void delete(ID id) {
        template.remove(id, clazz);
    }

    @Override
    public void delete(T t) {
        template.dropCollection(t.getClass());
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {
        iterable.forEach(T -> delete(T));
    }

    @Override
    public void deleteAll() {
        template.dropCollection(clazz);
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Page<T> findAll(Pageable pageable) {

        List<T> results = template.findAll(clazz);

        int pageSize = pageable.getPageSize();
        long pageOffset = pageable.getOffset();
        long total = pageOffset + results.size() + (results.size() == pageSize ? pageSize : 0);

        return new PageImpl<T>(results, pageable, total);
    }
}
