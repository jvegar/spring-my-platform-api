package com.api.my_platform.repository;

import com.api.my_platform.model.ServiceOffer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOfferRepository extends ReactiveCrudRepository<ServiceOffer, Long> {
}