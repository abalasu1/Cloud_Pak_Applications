package com.cargotracker.tracking.application.internal.commandservices;

import com.cargotracker.tracking.domain.model.aggregates.TrackingActivity;
import com.cargotracker.tracking.domain.model.aggregates.TrackingNumber;
import com.cargotracker.tracking.domain.model.commands.AddTrackingEventCommand;
import com.cargotracker.tracking.domain.model.commands.AssignTrackingNumberCommand;
import com.cargotracker.tracking.domain.model.entities.BookingId;
import com.cargotracker.tracking.infrastructure.repositories.TrackingRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Application Service class for the Tracking Command Service
 */
@Service
public class AssignTrackingIdCommandService {
    @Autowired
    private TrackingRepository trackingRepository;

    /**
     * Service Command method to assign a tracking id to the booked cargo
     * @return Tracking Number of the Cargo
     */
    public TrackingNumber assignTrackingNumberToCargo(AssignTrackingNumberCommand assignTrackingNumberCommand){
        String trackingNumber = nextTrackingNumber();
        //System.out.println("Tracking Number" + trackingNumber);
        assignTrackingNumberCommand.setTrackingNumber(trackingNumber);
        
        TrackingActivity activity = new TrackingActivity(assignTrackingNumberCommand);
        System.out.println("***Going to store in repository");
        trackingRepository.save(activity); //Store the tracking details

        return new TrackingNumber(trackingNumber);
    }

    /**
     * Service Command method to assign a route to a Cargo
     * @param addTrackingEventCommand
     */
    public String addTrackingEvent(AddTrackingEventCommand addTrackingEventCommand){
        TrackingActivity trackingActivity = trackingRepository.findByBookingNumber(
                        new BookingId(addTrackingEventCommand.getBookingId()));
        trackingActivity.addTrackingEvent(addTrackingEventCommand);
        
        System.out.println("TRACKINGACTIVITY=" + addTrackingEventCommand.getBookingId() + "***" + addTrackingEventCommand.getEventType());
        trackingRepository.save(trackingActivity);
        return "Tracking Event Added";
    }
    
    public String nextTrackingNumber() {
        String random = UUID.randomUUID().toString().toUpperCase();
        return random.substring(0, random.indexOf("-"));
    }
}