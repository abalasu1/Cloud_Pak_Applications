package com.cargotracker.trackingms.domain.projections;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TrackingProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private TrackingNumber trackingNumber; // Aggregate Identifier
    
    @Embedded
    private BookingId bookingId;

    public TrackingNumber getTrackingNumber(){
        return this.trackingNumber;
    }

    public BookingId getBookingId(){
        return this.bookingId;
    }

    public TrackingProjection(BookingId bookingId, TrackingNumber trackingNumber){
        this.trackingNumber = trackingNumber;
        this.bookingId = bookingId;
    }
}
