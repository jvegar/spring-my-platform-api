package com.api.my_platform.controller;

import com.api.my_platform.model.Education;
import com.api.my_platform.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService service;

    @GetMapping
    public Flux<Education> getAllEducation() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Education> getEducation(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Education> createEducation(@RequestBody Education education) {
        return service.save(education);
    }

    @PutMapping("/{id}")
    public Mono<Education> updateEducation(@PathVariable Long id, @RequestBody Education education) {
        return service.update(id, education);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEducation(@PathVariable Long id) {
        return service.deleteById(id);
    }
}