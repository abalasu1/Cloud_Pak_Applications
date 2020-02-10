package com.cargotracker.handlingms.infrastructure.repositories.jpa;

import com.cargotracker.handlingms.domain.model.aggregates.HandlingActivity;
import com.cargotracker.handlingms.domain.model.valueobjects.CargoBookingId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HandlingActivityRepository extends JpaRepository<HandlingActivity,Long> {
    HandlingActivity findByBookingId(CargoBookingId cargoBookingId);
}
