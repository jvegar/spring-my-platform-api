package com.api.my_platform.service;

import com.api.my_platform.model.PersonalInfo;
import com.api.my_platform.repository.PersonalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class PersonalInfoService {
    private final PersonalInfoRepository repository;

    public Flux<PersonalInfo> findAll() {
        return repository.findAll();
    }

    public Mono<PersonalInfo> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<PersonalInfo> save(PersonalInfo personalInfo) {
        return repository.save(personalInfo);
    }

    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Mono<PersonalInfo> update(Long id, PersonalInfo personalInfo) {
        return repository.findById(id)
                .flatMap(existing -> {
                    personalInfo.setId(id);
                    return repository.save(personalInfo);
                });
    }
}