package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;

import java.util.Date;
import java.util.List;

public interface PlannedArrivalRepository {
    List<PlannedArrival> getAllPlannedArrivals();

    PlannedArrival getPlannedArrivalById(int id);

    PlannedArrival addPlannedArrival(int arrivalId, Date arrivalTime, int holdingPointId, int buslineId);

    List<PlannedArrival> getPlannedArrivalsByHoldingPointId(int holdingPointId);

    List<PlannedArrival> getPlannedArrivalsByBuslineId(int buslineId);

    List<PlannedArrival> getPlannedArrivalsByHoldingPointIdAndBuslineId(int holdingPointId, int buslineId);

    void removePlannedArrival(int id);
}
