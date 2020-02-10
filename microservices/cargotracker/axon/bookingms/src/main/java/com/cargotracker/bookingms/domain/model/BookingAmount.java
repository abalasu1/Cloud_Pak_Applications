package com.cargotracker.bookingms.domain.model;

/**
 * Booking Amount of the Cargo
 */

public class BookingAmount {
    private int bookingAmount;

    public BookingAmount() {}
    public BookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

	public int getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(int bookingAmount) {
		this.bookingAmount = bookingAmount;
	}
}
