package com.spring.poc.user_feature.user_managment.service.persistence;

import com.spring.poc.user_feature.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAll();
}
