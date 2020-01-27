package com.cargotracker.tracking.interfaces.events;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.cargotracker.shareddomain.events.CargoHandledEvent;
import com.cargotracker.shareddomain.events.CargoRoutedEvent;

/**
 * Event Handler for the Cargo Routed Event that the Tracking Bounded Context is interested in
 */
@EnableAutoConfiguration
@EnableBinding(Sink.class)
public class CargoHandledEventHandler {	
    @StreamListener(target = Sink.INPUT)
    public void receiveEvent(CargoRoutedEvent cargoRoutedEvent) {
        //Process the Event
    	//System.out.println("Cargo Handled Event" + cargoHandledEvent.getCargoHandledEventData().getBookingId());    	
    }
}
