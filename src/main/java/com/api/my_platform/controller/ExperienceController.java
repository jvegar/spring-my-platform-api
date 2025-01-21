package com.api.my_platform.controller;

import com.api.my_platform.model.Experience;
import com.api.my_platform.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService service;

    @GetMapping
    public Flux<Experience> getAllExperience() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Experience> getExperience(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Experience> createExperience(@RequestBody Experience experience) {
        return service.save(experience);
    }

    @PutMapping("/{id}")
    public Mono<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        return service.update(id, experience);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteExperience(@PathVariable Long id) {
        return service.deleteById(id);
    }
}