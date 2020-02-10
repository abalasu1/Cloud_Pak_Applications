package com.cargotracker.bookingms.interfaces.rest.transform.assembler;


import com.cargotracker.bookingms.domain.commands.ChangeDestinationCommand;
import com.cargotracker.bookingms.interfaces.rest.transform.dto.ChangeDestinationResource;

public class ChangeDestinationCommandDTOAssembler {

    public static ChangeDestinationCommand toCommandFromDTO(ChangeDestinationResource changeDestinationResource){
        return new ChangeDestinationCommand(changeDestinationResource.getBookingId(),changeDestinationResource.getNewDestLocation());
    }
}
