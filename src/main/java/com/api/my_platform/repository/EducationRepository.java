package com.api.my_platform.repository;

import com.api.my_platform.model.Education;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends ReactiveCrudRepository<Education, Long> {
}