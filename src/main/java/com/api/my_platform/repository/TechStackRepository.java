package com.api.my_platform.repository;

import com.api.my_platform.model.TechStack;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechStackRepository extends ReactiveCrudRepository<TechStack, Long> {
} 