package com.quotemachine.quoteserver.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="QUOTE-PROXY", url="http://localhost:8001")
public interface QuoteProxy {
	@GetMapping("/random")
	String randomquote();
}