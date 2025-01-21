package com.api.my_platform.controller;

import com.api.my_platform.model.ServiceOffer;
import com.api.my_platform.service.ServiceOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceOfferController {
    private final ServiceOfferService service;

    @GetMapping
    public Flux<ServiceOffer> getAllServices() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ServiceOffer> getService(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ServiceOffer> createService(@RequestBody ServiceOffer service) {
        return this.service.save(service);
    }

    @PutMapping("/{id}")
    public Mono<ServiceOffer> updateService(@PathVariable Long id, @RequestBody ServiceOffer service) {
        return this.service.update(id, service);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteService(@PathVariable Long id) {
        return service.deleteById(id);
    }
}