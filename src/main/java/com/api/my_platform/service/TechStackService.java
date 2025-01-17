package com.api.my_platform.service;

import com.api.my_platform.model.TechStack;
import com.api.my_platform.repository.TechStackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TechStackService {
    private final TechStackRepository repository;

    public Flux<TechStack> findAll() {
        return repository.findAll();
    }

    public Mono<TechStack> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<TechStack> save(TechStack techStack) {
        return repository.save(techStack);
    }

    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Mono<TechStack> update(Long id, TechStack techStack) {
        return repository.findById(id)
                .flatMap(existing -> {
                    techStack.setId(id);
                    return repository.save(techStack);
                });
    }
} 