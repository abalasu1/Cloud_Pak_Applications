package com.cargotracker.tracking.infrastructure.rabbitmq.brokers;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Interface depicting all output channels
 */
public interface CargoEventSource {    
	String cargoHandlingChannel1 = "cargoHandlingChannel1";
	String cargoRoutingChannel = "cargoRoutingChannel";

	@Input
	SubscribableChannel cargoHandlingChannel1();
	
	@Input
	SubscribableChannel cargoRoutingChannel();
}
