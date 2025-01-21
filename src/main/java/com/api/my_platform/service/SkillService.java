package com.api.my_platform.service;

import com.api.my_platform.model.Skill;
import com.api.my_platform.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository repository;

    public Flux<Skill> findAll() {
        return repository.findAll();
    }

    public Mono<Skill> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Skill> save(Skill skill) {
        return repository.save(skill);
    }

    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Mono<Skill> update(Long id, Skill skill) {
        return repository.findById(id)
                .flatMap(existing -> {
                    skill.setId(id);
                    return repository.save(skill);
                });
    }
}