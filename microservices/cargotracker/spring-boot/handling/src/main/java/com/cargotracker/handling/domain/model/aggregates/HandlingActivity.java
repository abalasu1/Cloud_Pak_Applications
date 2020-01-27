package com.cargotracker.handling.domain.model.aggregates;

import com.cargotracker.handling.domain.model.valueobjects.CargoBookingId;
import com.cargotracker.handling.domain.model.valueobjects.Location;
import com.cargotracker.handling.domain.model.valueobjects.Type;
import com.cargotracker.handling.domain.model.valueobjects.VoyageNumber;
import com.cargotracker.shareddomain.events.CargoHandledEvent;
import com.cargotracker.shareddomain.events.CargoHandledEventData;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

/**
 * Root Aggregate for the Handling Bounded Context
 */
@Entity
@NamedQuery(name = "HandlingActivity.findByBookingId",
            query = "Select e from HandlingActivity e where e.cargoBookingId.bookingId = :bookingId")
@Table(name="handling_activity")
public class HandlingActivity extends AbstractAggregateRoot<HandlingActivity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name="event_type")
    private Type type;
    
    @Embedded
    private VoyageNumber voyageNumber;
    
    @Embedded
    private Location location;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "event_completion_time")
    private Date completionTime;

    @Embedded
    private CargoBookingId cargoBookingId;

    public HandlingActivity(){}

    /**
     * Constructor for the Handling Activity - With a VoyageNumber
     * @param cargoBookingId
     * @param completionTime
     * @param type
     * @param location
     * @param voyageNumber
     */
    public HandlingActivity(CargoBookingId cargoBookingId, Date completionTime,
                        Type type, Location location, VoyageNumber voyageNumber) {
        if (type.prohibitsVoyage()) {
            throw new IllegalArgumentException(
                    "VoyageNumber is not allowed with event type " + type);
        }

        this.voyageNumber = voyageNumber;
        this.completionTime = (Date) completionTime.clone();

        this.type = type;
        this.location = location;
        
        this.cargoBookingId = cargoBookingId;
        
        CargoHandledEvent cargoHandledEvent =
                new CargoHandledEvent(
                    new CargoHandledEventData(
                        this.cargoBookingId.getBookingId(),
                        this.completionTime,
                        this.location.getUnLocCode(),
                        this.type.toString(),
                        this.voyageNumber.getVoyageNumber()));


        //Add this domain event which needs to be fired when the new cargo is saved
        addDomainEvent(cargoHandledEvent);        
    }

    /**
     * Constructor for the Handling Activity - Without a VoyageNumber
     * @param cargoBookingId
     * @param completionTime
     * @param type
     * @param location
     */
    public HandlingActivity(CargoBookingId cargoBookingId, Date completionTime,
                          Type type, Location location) {
        System.out.println("***Type is**"+type);
        if (type.requiresVoyage()) {
            throw new IllegalArgumentException(
                    "VoyageNumber is required for event type " + type);
        }

        this.completionTime = (Date) completionTime.clone();
        this.type = type;
        
        this.location = location;
        this.cargoBookingId = cargoBookingId;
        
        this.voyageNumber = null;   

        CargoHandledEvent cargoHandledEvent =
                new CargoHandledEvent(
                        new CargoHandledEventData(
                                this.cargoBookingId.getBookingId(),
                                this.completionTime,
                                this.location.getUnLocCode(),
                                this.type.toString(),
                               ""));


        //Add this domain event which needs to be fired when the new cargo is saved
        addDomainEvent(cargoHandledEvent);        
    }


    public Type getType() {
        return this.type;
    }

    public VoyageNumber getVoyage() {
        return this.voyageNumber;
    }

    public Date getCompletionTime() {
        return new Date(this.completionTime.getTime());
    }

    public Location getLocation() { return this.location; }

    public CargoBookingId getCargoBookingId() {
        return this.cargoBookingId;
    }
    
    /**
     * Method to register the event
     * @param event
     */
    public void addDomainEvent(Object event){
    	System.out.println("Event Trigerred");
        registerEvent(event);
    }
}