package com.spring.poc.user.managment.feature.adapter.persistence;

import com.spring.poc.user.managment.feature.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
