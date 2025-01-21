package com.api.my_platform.repository;

import com.api.my_platform.model.Skill;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends ReactiveCrudRepository<Skill, Long> {
}