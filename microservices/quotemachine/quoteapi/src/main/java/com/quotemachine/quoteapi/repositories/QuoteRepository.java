package com.quotemachine.quoteapi.repositories;

import com.quotemachine.quoteapi.domain.Quote;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuoteRepository extends PagingAndSortingRepository<Quote, Long> {

    @Query("select quote from Quote quote order by RAND()")
    public List<Quote> randomFortunes(Pageable pageable);
}
