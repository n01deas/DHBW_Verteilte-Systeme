package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;

import java.util.Date;
import java.util.List;

public interface BusHistoryRepository {

    List<BusHistory> getAllBusHistories();

    List<BusHistory> getBusHistoryByLineId(int id);

    List<BusHistory> getBusHistoryByBusId(int id);

    List<BusHistory> getBusHistoryByHoldingPointId(int id);

    List<BusHistory> getBusHistoryByLineIdAndHoldingPoint(int busLineId, int holdingPointId);

    BusHistory addBusHistory(int busId, int busLineId, int holdingPointId, Date arrival);
}
