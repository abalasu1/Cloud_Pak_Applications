package com.quotemachine.quoteserver.scheduler;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.quotemachine.quoteserver.proxy.QuoteProxy;

@Component
public class QuoteScheduler {
	private final Counter quoteCounter;
    
	/*@Autowired
	private QuoteProxy quoteProxy;*/  

    public QuoteScheduler(MeterRegistry meterRegistry) {
    	/*String quote = quoteProxy.randomquote();
    	System.out.println(quote);*/
    	quoteCounter = meterRegistry.counter("quoteserver.created");
    }
    
    @Scheduled(fixedDelay = 5000)
    public void increaseCounter() {
    	quoteCounter.increment();
    }
}
