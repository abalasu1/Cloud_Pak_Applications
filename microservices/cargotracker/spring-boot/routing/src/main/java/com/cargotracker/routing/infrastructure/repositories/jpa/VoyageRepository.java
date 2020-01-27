package com.cargotracker.routing.infrastructure.repositories.jpa;

import com.cargotracker.routing.domain.model.aggregates.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    List<Voyage> findAll() ;
}