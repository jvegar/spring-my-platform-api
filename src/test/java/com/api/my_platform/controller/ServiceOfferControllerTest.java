package com.api.my_platform.controller;

import com.api.my_platform.model.ServiceOffer;
import com.api.my_platform.service.ServiceOfferService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(ServiceOfferController.class)
class ServiceOfferControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private ServiceOfferService service;

    @InjectMocks
    private ServiceOfferController controller;

    public ServiceOfferControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllServices() throws Exception {
        ServiceOffer serviceOffer = new ServiceOffer();
        serviceOffer.setId(1L);
        serviceOffer.setTitle("Test Service");

        when(service.findAll()).thenReturn(Flux.just(serviceOffer));

        webTestClient.get().uri("/api/services")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(ServiceOffer.class)
                .hasSize(1)
                .contains(serviceOffer);
    }

    @Test
    void createService() throws Exception {
        ServiceOffer serviceOffer = new ServiceOffer();
        serviceOffer.setTitle("New Service");

        when(service.save(any(ServiceOffer.class))).thenReturn(Mono.just(serviceOffer));

        webTestClient.post().uri("/api/services")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(serviceOffer)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ServiceOffer.class)
                .isEqualTo(serviceOffer);
    }

    @Test
    void updateService() throws Exception {
        ServiceOffer serviceOffer = new ServiceOffer();
        serviceOffer.setId(1L);
        serviceOffer.setTitle("Updated Service");

        when(service.update(any(Long.class), any(ServiceOffer.class))).thenReturn(Mono.just(serviceOffer));

        webTestClient.put().uri("/api/services/1")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(serviceOffer)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ServiceOffer.class)
                .isEqualTo(serviceOffer);
    }

    @Test
    void deleteService() throws Exception {
        when(service.deleteById(1L)).thenReturn(Mono.empty());

        webTestClient.delete().uri("/api/services/1")
                .exchange()
                .expectStatus().isNoContent();
    }
}