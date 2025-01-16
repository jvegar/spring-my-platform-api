package com.api.my_platform.repository;

import com.api.my_platform.model.PersonalInfo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInfoRepository extends ReactiveCrudRepository<PersonalInfo, Long> {
}