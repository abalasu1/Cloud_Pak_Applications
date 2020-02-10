package com.cargotracker.handlingms.application.internal.commandservices;

import com.cargotracker.handlingms.domain.model.aggregates.HandlingActivity;
import com.cargotracker.handlingms.domain.model.commands.HandlingActivityRegistrationCommand;
import com.cargotracker.handlingms.domain.model.valueobjects.CargoBookingId;
import com.cargotracker.handlingms.domain.model.valueobjects.Location;
import com.cargotracker.handlingms.domain.model.valueobjects.Type;
import com.cargotracker.handlingms.domain.model.valueobjects.VoyageNumber;
import com.cargotracker.handlingms.infrastructure.repositories.jpa.HandlingActivityRepository;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class HandlingActivityRegistrationCommandService {


        private HandlingActivityRepository handlingActivityRepository;

        public HandlingActivityRegistrationCommandService(HandlingActivityRepository handlingActivityRepository){
                this.handlingActivityRepository = handlingActivityRepository;
        }

        /**
         * Service Command method to register a new Handling Activity
         * @return BookingId of the CargoBookingId
         */
        @Transactional
        public void registerHandlingActivityService(HandlingActivityRegistrationCommand handlingActivityRegistrationCommand){
                System.out.println("Handling Voyage Number is"+handlingActivityRegistrationCommand.getVoyageNumber());
                if(!handlingActivityRegistrationCommand.getVoyageNumber().equals("")) {
                        HandlingActivity handlingActivity = new HandlingActivity(
                                new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                                handlingActivityRegistrationCommand.getCompletionTime(),
                                Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                                new Location(handlingActivityRegistrationCommand.getUnLocode()),
                                new VoyageNumber(handlingActivityRegistrationCommand.getVoyageNumber()));
                        handlingActivityRepository.save(handlingActivity);

                }else{
                        HandlingActivity handlingActivity = new HandlingActivity(
                                new CargoBookingId(handlingActivityRegistrationCommand.getBookingId()),
                                handlingActivityRegistrationCommand.getCompletionTime(),
                                Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                                new Location(handlingActivityRegistrationCommand.getUnLocode()));
                        handlingActivityRepository.save(handlingActivity);
                }




        }
}
