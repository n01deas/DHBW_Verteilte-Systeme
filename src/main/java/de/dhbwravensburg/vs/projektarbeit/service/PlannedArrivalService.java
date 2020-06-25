package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.PlannedArrivalExceptions.PlannedArrivalNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;

import java.util.Date;
import java.util.List;

public interface PlannedArrivalService {
    List<PlannedArrival> getAllPlannedArrivals();

    PlannedArrival getPlannedArrivalById(int id) throws PlannedArrivalNotExistsException;

    PlannedArrival addPlannedArrival(int arrivalId, Date arrivalTime, int holdingPointId, int buslineId);

    List<PlannedArrival> getPlannedArrivalsByHoldingPointId(int holdingPointId) throws HoldingPointNotExistsException;

    List<PlannedArrival> getPlannedArrivalsByBuslineId(int buslineId) throws BuslineDoesNotExistsException;

    List<PlannedArrival> getPlannedArrivalsByHoldingPointIdAndBuslineId(int holdingPointId, int buslineId) throws HoldingPointNotExistsException, BuslineDoesNotExistsException;

    void removePlannedArrival(int id) throws PlannedArrivalNotExistsException;
}
