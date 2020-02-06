package com.cargotracker.tracking.domain.model.aggregates;

import com.cargotracker.tracking.domain.model.commands.AddTrackingEventCommand;
import com.cargotracker.tracking.domain.model.commands.AssignTrackingNumberCommand;

import com.cargotracker.tracking.domain.model.entities.BookingId;
import com.cargotracker.tracking.domain.model.entities.TrackingActivityEvent;

import com.cargotracker.tracking.domain.model.valueobjects.TrackingEventType;
import com.cargotracker.tracking.domain.model.valueobjects.TrackingLocation;
import com.cargotracker.tracking.domain.model.valueobjects.TrackingEvent;
import com.cargotracker.tracking.domain.model.valueobjects.TrackingVoyageNumber;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Embedded;

@Entity
@NamedQueries({
        @NamedQuery(name = "TrackingActivity.findAll",
                query = "Select t from TrackingActivity t"),
        @NamedQuery(name = "TrackingActivity.findByTrackingNumber",
                query = "Select t from TrackingActivity t where t.trackingNumber = :trackingNumber"),
        @NamedQuery(name = "TrackingActivity.getAllTrackingNos",
                query = "Select t.trackingNumber from TrackingActivity t"),
        @NamedQuery(name="TrackingActivity.findByBookingNumber",
                query = "Select t from TrackingActivity t where t.bookingId = :bookingId")})
@Table(name="tracking_activity")
public class TrackingActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    private TrackingNumber trackingNumber; // Aggregate Identifier
    
    @Embedded
    private BookingId bookingId;
    
    @Embedded
    private TrackingActivityEvent trackingActivityEvent;

    public TrackingActivity(){}

    /**
     * Creates a new Tracking Number
     * @param assignTrackingNumberCommand
     */
    public TrackingActivity(AssignTrackingNumberCommand assignTrackingNumberCommand){
    	this.trackingNumber = new TrackingNumber(assignTrackingNumberCommand.getTrackingNumber());
        this.bookingId = new BookingId((assignTrackingNumberCommand.getBookingId()));
        //this.trackingActivityEvent = TrackingActivityEvent.EMPTY_ACTIVITY;
        /*this.trackingActivityEvent.getTrackingEvents().add(
                new TrackingEvent(
                new TrackingVoyageNumber(""),
                new TrackingLocation(""),
                new TrackingEventType("ROUTED",new Date())));*/
    }

    /**
     * Add a tracking event to the Tracking Details
     * @param addTrackingEventCommand
     */
    public void addTrackingEvent(AddTrackingEventCommand addTrackingEventCommand){
        TrackingEvent trackingEvent = new TrackingEvent(
                new TrackingVoyageNumber(addTrackingEventCommand.getVoyageNumber()),
                new TrackingLocation(addTrackingEventCommand.getLocation()),
                new TrackingEventType(addTrackingEventCommand.getEventType(),addTrackingEventCommand.getEventTime()));
        //System.out.println("******TRACKINGEVENT******="+addTrackingEventCommand.getEventType());
        this.trackingActivityEvent.addTrackingEvent(trackingEvent);
    }
    
    public TrackingNumber getTrackingNumber(){
        return this.trackingNumber;
    }

    public BookingId getBookingId(){
        return this.bookingId;
    }

    public TrackingActivityEvent getTrackingActivityEvents() {
        return this.trackingActivityEvent;
    }


	public void setTrackingActivityEvents(TrackingActivityEvent trackingActivityEvent) {
		this.trackingActivityEvent = trackingActivityEvent;
	}

	public TrackingActivityEvent getTrackingActivityEvent() {
		return trackingActivityEvent;
	}

	public void setTrackingNumber(TrackingNumber trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setBookingId(BookingId bookingId) {
		this.bookingId = bookingId;
	}
}