package com.cargotracker.handling.application.internal.queryservices;

import com.cargotracker.handling.domain.model.valueobjects.CargoBookingId;
import com.cargotracker.handling.domain.model.valueobjects.HandlingActivityHistory;
import com.cargotracker.handling.infrastructure.repositories.HandlingActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Application Service which caters to all queries related to the Handling Activity Aggregate
 */
@Service
public class HandlingHistoryService {
    private HandlingActivityRepository handlingActivityRepository;

    /*public HandlingActivityHistory getHandlingActivityHistory(String bookingId){
        return handlingActivityRepository.findByBookingId(new CargoBookingId(bookingId));
    }*/
}