package com.api.my_platform.controller;

import com.api.my_platform.model.TechStack;
import com.api.my_platform.service.TechStackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tech-stack")
@RequiredArgsConstructor
public class TechStackController {
    private final TechStackService service;

    @GetMapping
    public Flux<TechStack> getAllTechStacks() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TechStack> getTechStack(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TechStack> createTechStack(@RequestBody TechStack techStack) {
        return service.save(techStack);
    }

    @PutMapping("/{id}")
    public Mono<TechStack> updateTechStack(@PathVariable Long id, @RequestBody TechStack techStack) {
        return service.update(id, techStack);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTechStack(@PathVariable Long id) {
        return service.deleteById(id);
    }
} 