package com.api.my_platform.service;

import com.api.my_platform.model.ServiceOffer;
import com.api.my_platform.repository.ServiceOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ServiceOfferService {
    private final ServiceOfferRepository repository;

    public Flux<ServiceOffer> findAll() {
        return repository.findAll();
    }

    public Mono<ServiceOffer> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<ServiceOffer> save(ServiceOffer service) {
        return repository.save(service);
    }

    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    public Mono<ServiceOffer> update(Long id, ServiceOffer service) {
        return repository.findById(id)
                .flatMap(existing -> {
                    service.setId(id);
                    return repository.save(service);
                });
    }
}