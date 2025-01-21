package com.api.my_platform.controller;

import com.api.my_platform.model.Skill;
import com.api.my_platform.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService service;

    @GetMapping
    public Flux<Skill> getAllSkills() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Skill> getSkill(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Skill> createSkill(@RequestBody Skill skill) {
        return service.save(skill);
    }

    @PutMapping("/{id}")
    public Mono<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        return service.update(id, skill);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSkill(@PathVariable Long id) {
        return service.deleteById(id);
    }
}