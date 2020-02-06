package com.cargotracker.tracking.interfaces.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.cargotracker.shareddomain.events.CargoRoutedEvent;
import com.cargotracker.tracking.application.internal.commandservices.AssignTrackingIdCommandService;
import com.cargotracker.tracking.infrastructure.rabbitmq.brokers.CargoEventSource;
import com.cargotracker.tracking.interfaces.events.transform.TrackingDetailsCommandEventAssembler;

/**
 * Event Handler for the Cargo Routed Event that the Tracking Bounded Context is interested in
 */
@EnableAutoConfiguration
@EnableBinding(CargoEventSource.class)
public class CargoRoutedEventHandler {
	@Autowired
	AssignTrackingIdCommandService assignTrackingIdCommandService;
	
    @StreamListener(target = CargoEventSource.cargoRoutingChannel)
    public void receiveEvent(CargoRoutedEvent cargoRoutedEvent) {
        //Process the Event
    	//System.out.println("Cargo Routed Event" + cargoRoutedEvent.getCargoRoutedEventData().getBookingId());
        assignTrackingIdCommandService.assignTrackingNumberToCargo(TrackingDetailsCommandEventAssembler.toCommandFromEvent(cargoRoutedEvent));        
    }
}