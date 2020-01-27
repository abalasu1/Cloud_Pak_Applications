package com.cargotracker.tracking.domain.model.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Aggregate Identifier for the Cargo Aggregate
 */
@Embeddable
public class BookingId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="booking_id")
    private String bookingId;

    public BookingId(){}
    public BookingId(String bookingId){this.bookingId = bookingId;}
    
    public String getBookingId(){return this.bookingId;}
}