package org.mambofish.spring.data.jsondb.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author vince
 */
@NoRepositoryBean
public interface JsonDBRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}
