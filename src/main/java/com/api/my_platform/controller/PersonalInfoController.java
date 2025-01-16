package com.api.my_platform.controller;

import com.api.my_platform.model.PersonalInfo;
import com.api.my_platform.service.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personal-info")
@RequiredArgsConstructor
public class PersonalInfoController {
    private final PersonalInfoService service;

    @GetMapping
    public Flux<PersonalInfo> getAllPersonalInfo() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PersonalInfo> getPersonalInfo(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo) {
        return service.save(personalInfo);
    }

    @PutMapping("/{id}")
    public Mono<PersonalInfo> updatePersonalInfo(@PathVariable Long id, @RequestBody PersonalInfo personalInfo) {
        return service.update(id, personalInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePersonalInfo(@PathVariable Long id) {
        return service.deleteById(id);
    }
}