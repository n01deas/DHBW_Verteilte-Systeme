package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusDoesNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;

import java.util.Date;
import java.util.List;

public interface BusHistoryService {

    List<BusHistory> getAllBusHistories();

    List<BusHistory> getBusHistoryByLineId(int id) throws BuslineDoesNotExistsException;

    List<BusHistory> getBusHistoryByBusId(int id) throws BusDoesNotExistException;

    List<BusHistory> getBusHistoryByHoldingPointId(int id) throws HoldingPointNotExistsException;

    List<BusHistory> getBusHistoryByLineIdAndHoldingPoint(int busLineId, int holdingPointId) throws BuslineDoesNotExistsException, HoldingPointNotExistsException;

    BusHistory addBusHistory(int busId, int busLineId, int holdingPointId, Date arrival);

    int getDelayOfBuslineAtHoldingPoint(int buslineId, int holdingPointId) throws BuslineDoesNotExistsException;
}
