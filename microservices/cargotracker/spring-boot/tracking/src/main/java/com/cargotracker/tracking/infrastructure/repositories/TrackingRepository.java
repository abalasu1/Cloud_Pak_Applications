package com.cargotracker.tracking.infrastructure.repositories;

import com.cargotracker.tracking.domain.model.aggregates.TrackingNumber;
import com.cargotracker.tracking.domain.model.entities.BookingId;
import com.cargotracker.tracking.domain.model.aggregates.TrackingActivity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository class for the Cargo Aggregate
 */
public interface TrackingRepository extends JpaRepository<TrackingActivity, Long> {
	 TrackingActivity findByTrackingNumber(TrackingNumber trackingNumber);
	 TrackingActivity findByBookingNumber(BookingId bookingId);

     //List<TrackingNumber> findAllTrackingNumbers();
     List<TrackingActivity> findAll();
}
