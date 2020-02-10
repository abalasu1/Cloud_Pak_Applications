package com.cargotracker.bookingms.application.internal.commandgateways;

import com.cargotracker.bookingms.application.internal.outboundservices.acl.ExternalCargoRoutingService;
import com.cargotracker.bookingms.domain.commands.AssignRouteToCargoCommand;
import com.cargotracker.bookingms.domain.commands.BookCargoCommand;
import com.cargotracker.bookingms.domain.commands.ChangeDestinationCommand;
import com.cargotracker.bookingms.domain.model.CargoItinerary;
import com.cargotracker.bookingms.domain.model.Leg;
import com.cargotracker.bookingms.domain.model.RouteSpecification;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application Service Class to Book a Cargo, Route a Cargo and Change the Destination of a Cargo
 * All Commands to the Cargo Aggregate are grouped into this sevice class
 */
@Service
public class CargoBookingService {

    private final CommandGateway commandGateway;
    private ExternalCargoRoutingService externalCargoRoutingService;


    public CargoBookingService(CommandGateway commandGateway,ExternalCargoRoutingService externalCargoRoutingService){
        this.commandGateway = commandGateway;
        this.externalCargoRoutingService = externalCargoRoutingService;

    }

    /**
     * Book a Cargo
     * @param bookCargoCommand
     */
    public void bookCargo(BookCargoCommand bookCargoCommand){
        commandGateway.send(bookCargoCommand);
    }

    /**
     * Change the Destination of a Cargo
     * @param changeDestinationCommand
     */
    public void changeDestinationOfCargo(ChangeDestinationCommand changeDestinationCommand) {
        commandGateway.send(changeDestinationCommand);
    }

    /**
     * Assigns a Route to a Cargo
     * @param assignRouteToCargoCommand
     */
    public void assignRouteToCargo(AssignRouteToCargoCommand assignRouteToCargoCommand){
        commandGateway.send(assignRouteToCargoCommand);
    }
    
    /**
     * Makes a call to the Routing Service to get the corresponding legs for a route
     * @return
     */
    public List<Leg> getLegsForRoute(RouteSpecification routeSpecification){
        CargoItinerary itinerary = externalCargoRoutingService.fetchRouteForSpecification(routeSpecification);
        return itinerary.getLegs();
    } 

}
