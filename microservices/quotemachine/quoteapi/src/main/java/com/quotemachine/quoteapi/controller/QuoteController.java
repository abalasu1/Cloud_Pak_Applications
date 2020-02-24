package com.quotemachine.quoteapi.controller;

import com.quotemachine.quoteapi.domain.Quote;
import com.quotemachine.quoteapi.repositories.QuoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
public class QuoteController {

    @Autowired
    QuoteRepository repository;

    @RequestMapping("/quotes")
    public Iterable<Quote> fortunes() {
        return repository.findAll();
    }

    @RequestMapping("/random")
    public Quote randomFortune() {
        List<Quote> randomQuotes = repository.randomFortunes(new PageRequest(0, 1));
        return randomQuotes.get(0);
    }
}