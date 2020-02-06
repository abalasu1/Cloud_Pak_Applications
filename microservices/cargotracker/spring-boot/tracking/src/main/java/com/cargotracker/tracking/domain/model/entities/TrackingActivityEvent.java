package com.cargotracker.tracking.domain.model.entities;

import com.cargotracker.tracking.domain.model.valueobjects.TrackingEvent;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TrackingActivityEvent {
    public static final TrackingActivityEvent EMPTY_ACTIVITY = new TrackingActivityEvent();
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tracking_id")
    private List<TrackingEvent> trackingEvents = new ArrayList<TrackingEvent>();

    public TrackingActivityEvent() {
        // Nothing to initialize.
    }

    public TrackingActivityEvent(List<TrackingEvent> trackingEvents) {
        this.trackingEvents = trackingEvents;
    }

    public List<TrackingEvent> getTrackingEvents() {
        return trackingEvents;
    }

	public void setTrackingEvents(List<TrackingEvent> trackingEvents) {
		this.trackingEvents = trackingEvents;
	}
	
	public void addTrackingEvent(TrackingEvent trackingEvent) {
		trackingEvents.add(trackingEvent);
	}
}