package com.cargotracker.trackingms.domain.model;

import com.cargotracker.trackingms.domain.commands.AssignTrackingDetailsToCargoCommand;
import com.cargotracker.trackingms.domain.events.CargoTrackedEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class TrackingActivity {
    @AggregateIdentifier
    private String trackingId; // Aggregate Identifier

    protected TrackingActivity(){}
    public TrackingActivity(String trackingId) {
		this.trackingId = trackingId;
	}

	@CommandHandler
    public TrackingActivity(AssignTrackingDetailsToCargoCommand assignTrackingDetailsToCargoCommand) {
    	this.trackingId = assignTrackingDetailsToCargoCommand.getTrackingId();
		System.out.println("COMMAND HANDLER INVOKED ..." + trackingId);
    	
        apply(new CargoTrackedEvent(
                    assignTrackingDetailsToCargoCommand.getBookingId(),
                    assignTrackingDetailsToCargoCommand.getTrackingId()));
    }
}