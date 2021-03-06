package com.cargotracker.bookingms.domain.queries;

import java.util.List;

import com.cargotracker.bookingms.domain.projections.CargoSummary;

/**
 * Implementation of the Cargo Summary Results class which contains the results of the execution of the
 * ListCargosSummaryQuery. The result contains data from the CargoSummary Projection
 */
public class ListCargoSummaryResult {

    private final List<CargoSummary> cargoSummaries;

    public ListCargoSummaryResult(List<CargoSummary> cargoSummaries) {
        this.cargoSummaries = cargoSummaries;
    }

    public List<CargoSummary> getCardSummaries() {
        return cargoSummaries;
    }

    @Override
    public String toString() {
        return "Listing Cargo Summaries = " + cargoSummaries;
    }
}
