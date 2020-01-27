package com.cargotracker.tracking.interfaces.events.transform;

import com.cargotracker.shareddomain.events.CargoRoutedEvent;
import com.cargotracker.tracking.domain.model.commands.AssignTrackingNumberCommand;

/**
 * Assembler class to convert the Cargo Routed Event to the Assign Tracking Number Command Model
 */
public class TrackingDetailsCommandEventAssembler {

    /**
     * Static method within the Assembler class
     * @param cargoRoutedEvent
     * @return AssignTrackingNumberCommand Model
     */
    public static AssignTrackingNumberCommand toCommandFromEvent(CargoRoutedEvent cargoRoutedEvent){
        return new AssignTrackingNumberCommand(cargoRoutedEvent.getCargoRoutedEventData().getBookingId(),"");
    }
}