package com.cargotracker.routingms.infrastructure.repositories.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cargotracker.routingms.domain.model.aggregates.Voyage;

import java.util.List;

/**
 * Repository class for the Voyage Aggregate.
 */
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    /**
     * Find all Voyage Aggregates
     * @return
     */
    List<Voyage> findAll() ;


}
