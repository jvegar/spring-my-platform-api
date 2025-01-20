package com.api.my_platform.service;

import com.api.my_platform.model.Education;
import com.api.my_platform.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EducationService {
    private final EducationRepository repository;

    public Flux<Education> findAll() {
        return repository.findAll();
    }

    public Mono<Education> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Education> save(Education education) {
        return repository.save(education);
    }

    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Mono<Education> update(Long id, Education education) {
        return repository.findById(id)
                .flatMap(existing -> {
                    education.setId(id);
                    return repository.save(education);
                });
    }
}