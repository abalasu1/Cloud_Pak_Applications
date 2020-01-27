package com.cargotracker.routing.application.internal.services;

import com.cargotracker.routing.domain.model.aggregates.Voyage;
import com.cargotracker.routing.infrastructure.repositories.jpa.VoyageRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CargoRoutingQueryService {

    private VoyageRepository voyageRepository; // Inject Dependencies

    public CargoRoutingQueryService(VoyageRepository voyageRepository){
        this.voyageRepository = voyageRepository;
    }
    
    @Transactional
    public List<Voyage> findAll(){
        return voyageRepository.findAll();
    }
}