package com.api.my_platform.service;

import com.api.my_platform.model.Experience;
import com.api.my_platform.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository repository;

    public Flux<Experience> findAll() {
        return repository.findAll();
    }

    public Mono<Experience> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Experience> save(Experience experience) {
        return repository.save(experience);
    }

    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Mono<Experience> update(Long id, Experience experience) {
        return repository.findById(id)
                .flatMap(existing -> {
                    experience.setId(id);
                    return repository.save(experience);
                });
    }
}