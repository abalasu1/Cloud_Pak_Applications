package com.cargotracker.tracking.interfaces.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.cargotracker.shareddomain.events.CargoHandledEvent;
import com.cargotracker.tracking.application.internal.commandservices.AssignTrackingIdCommandService;
import com.cargotracker.tracking.infrastructure.rabbitmq.brokers.CargoEventSource;
import com.cargotracker.tracking.interfaces.events.transform.TrackingActivityCommandEventAssembler;

/**
 * Event Handler for the Cargo Routed Event that the Tracking Bounded Context is interested in
 */
@EnableAutoConfiguration
@EnableBinding(CargoEventSource.class)
public class CargoHandledEventHandler {
	@Autowired
	AssignTrackingIdCommandService assignTrackingIdCommandService;
	
    @StreamListener(target = CargoEventSource.cargoHandlingChannel1)
    public void receiveEvent(CargoHandledEvent cargoHandledEvent) {
        //Process the Event
    	//System.out.println("Cargo Handled Event" + cargoHandledEvent.getCargoHandledEventData().getBookingId());
    	assignTrackingIdCommandService.addTrackingEvent(TrackingActivityCommandEventAssembler.toCommandFromEvent(cargoHandledEvent));        
    }
}
