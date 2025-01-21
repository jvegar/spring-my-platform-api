package com.api.my_platform.repository;

import com.api.my_platform.model.Experience;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends ReactiveCrudRepository<Experience, Long> {
}