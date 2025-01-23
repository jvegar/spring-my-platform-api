package com.api.my_platform.service;

import com.api.my_platform.model.ServiceOffer;
import com.api.my_platform.repository.ServiceOfferRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ServiceOfferServiceTest {

    @Mock
    private ServiceOfferRepository repository;

    @InjectMocks
    private ServiceOfferService service;

    public ServiceOfferServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        ServiceOffer serviceOffer = new ServiceOffer();
        serviceOffer.setId(1L);
        serviceOffer.setTitle("Test Service");

        when(repository.findAll()).thenReturn(Flux.just(serviceOffer));

        StepVerifier.create(service.findAll())
                .expectNext(serviceOffer)
                .verifyComplete();

        verify(repository, times(1)).findAll();
    }

    @Test
    void findById() {
        ServiceOffer serviceOffer = new ServiceOffer();
        serviceOffer.setId(1L);
        serviceOffer.setTitle("Test Service");

        when(repository.findById(1L)).thenReturn(Mono.just(serviceOffer));

        StepVerifier.create(service.findById(1L))
                .expectNext(serviceOffer)
                .verifyComplete();

        verify(repository, times(1)).findById(1L);
    }

    @Test
    void save() {
        ServiceOffer serviceOffer = new ServiceOffer();
        serviceOffer.setTitle("New Service");

        when(repository.save(any(ServiceOffer.class))).thenReturn(Mono.just(serviceOffer));

        StepVerifier.create(service.save(serviceOffer))
                .expectNext(serviceOffer)
                .verifyComplete();

        verify(repository, times(1)).save(serviceOffer);
    }

    @Test
    void deleteById() {
        when(repository.deleteById(1L)).thenReturn(Mono.empty());

        StepVerifier.create(service.deleteById(1L))
                .verifyComplete();

        verify(repository, times(1)).deleteById(1L);
    }
}