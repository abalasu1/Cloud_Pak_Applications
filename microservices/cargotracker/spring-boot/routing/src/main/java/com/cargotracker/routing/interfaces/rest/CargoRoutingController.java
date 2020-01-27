package com.cargotracker.routing.interfaces.rest;

import com.cargotracker.routing.application.internal.services.CargoRoutingQueryService;
import com.cargotracker.routing.domain.model.aggregates.Voyage;
import com.cargotracker.routing.domain.model.entities.CarrierMovement;

import com.cargotracker.routing.shareddomain.model.TransitEdge;
import com.cargotracker.routing.shareddomain.model.TransitPath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cargorouting")
public class CargoRoutingController {

    private CargoRoutingQueryService cargoRoutingQueryService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param cargoRoutingQueryService
     */
    public CargoRoutingController(CargoRoutingQueryService cargoRoutingQueryService){
        this.cargoRoutingQueryService = cargoRoutingQueryService;
    }


    /**
     *
     * @param originUnLocode
     * @param destinationUnLocode
     * @param deadline
     * @return TransitPath - The optimal route for a Route Specification
     */

    @GetMapping(path = "/optimalRoute")
    @ResponseBody
    public TransitPath findOptimalRoute(
             @RequestParam("origin") String originUnLocode,
             @RequestParam("destination") String destinationUnLocode,
             @RequestParam("deadline") String deadline) {

        List<Voyage> voyages = cargoRoutingQueryService.findAll();
        TransitPath transitPath = new TransitPath();
        
        List<TransitEdge> transitEdges = new ArrayList<>();
        for(Voyage voyage:voyages){
            TransitEdge transitEdge = new TransitEdge();
            transitEdge.setVoyageNumber(voyage.getVoyageNumber().getVoyageNumber());
            
            CarrierMovement movement =
                    ((List<CarrierMovement>)voyage.getSchedule().getCarrierMovements()).get(0);
            
            transitEdge.setFromDate(movement.getArrivalDate());
            transitEdge.setToDate(movement.getDepartureDate());
            
            transitEdge.setFromUnLocode(movement.getDepartureLocation().getUnLocCode());
            transitEdge.setToUnLocode(movement.getArrivalLocation().getUnLocCode());
            
            transitEdges.add(transitEdge);
        }

        transitPath.setTransitEdges(transitEdges);
        return transitPath;
    }
}