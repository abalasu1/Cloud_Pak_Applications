package com.quotemachine.quoteserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quotemachine.quoteserver.proxy.QuoteProxy;

@RestController
public class QuoteServerController {
	@Autowired
	private QuoteProxy quoteProxy;
	
	@RequestMapping(value="/myquote", method = RequestMethod.GET)
	public String myquote () {
		return quoteProxy.randomquote();
	}
}
