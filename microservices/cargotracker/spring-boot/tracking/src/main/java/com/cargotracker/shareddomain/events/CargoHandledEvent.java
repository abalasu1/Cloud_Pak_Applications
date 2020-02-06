package com.cargotracker.shareddomain.events;

import com.cargotracker.shareddomain.events.CargoHandledEventData;

public class CargoHandledEvent{

    private CargoHandledEventData cargoHandledEventData;
    
    public CargoHandledEvent() {}
    public CargoHandledEvent(CargoHandledEventData cargoHandledEventData) { this.cargoHandledEventData = cargoHandledEventData; }
    
    public CargoHandledEventData getCargoHandledEventData() {
        return cargoHandledEventData;
    }
}
