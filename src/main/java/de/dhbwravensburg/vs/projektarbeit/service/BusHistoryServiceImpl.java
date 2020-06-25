package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusDoesNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.helpers.BusHistoryComparator;
import de.dhbwravensburg.vs.projektarbeit.helpers.PlannedArrivalComparator;
import de.dhbwravensburg.vs.projektarbeit.repositories.BusHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class BusHistoryServiceImpl implements BusHistoryService{

    @Autowired
    BusHistoryRepository busHistoryRepository;

    @Autowired
    PlannedArrivalService plannedArrivalService;

    /** gibt alle Halte zurück von allen bussen, allen linien allen zeiten und allen haltestellen
     *
     * @return bushistories
     */
    @Override
    public List<BusHistory> getAllBusHistories() {
        return busHistoryRepository.getAllBusHistories();
    }

    /** gibt alle Halte von einer Linie aus
     *
     * @param id
     * @return histories
     * @throws BuslineDoesNotExistsException
     */
    @Override
    public List<BusHistory> getBusHistoryByLineId(int id) throws BuslineDoesNotExistsException {
        return busHistoryRepository.getBusHistoryByLineId(id);
    }

    /** Halte eines Buses
     *
     * @param id
     * @return histories
     * @throws BusDoesNotExistException
     */
    @Override
    public List<BusHistory> getBusHistoryByBusId(int id) throws BusDoesNotExistException {
        return busHistoryRepository.getBusHistoryByBusId(id);
    }

    /** Halte an der Haltestelle
     *
     * @param id
     * @return histories
     * @throws HoldingPointNotExistsException
     */
    @Override
    public List<BusHistory> getBusHistoryByHoldingPointId(int id) throws HoldingPointNotExistsException {
        return busHistoryRepository.getBusHistoryByHoldingPointId(id);
    }

    /** Halte bei einer Haltestelle von einer bestimmten Linie
     *
     * @param busLineId
     * @param holdingPointId
     * @return histories
     * @throws BuslineDoesNotExistsException
     * @throws HoldingPointNotExistsException
     */
    @Override
    public List<BusHistory> getBusHistoryByLineIdAndHoldingPoint(int busLineId, int holdingPointId) throws BuslineDoesNotExistsException, HoldingPointNotExistsException {
        return busHistoryRepository.getBusHistoryByLineIdAndHoldingPoint(busLineId, holdingPointId);
    }

    /** hinzuügen eines Haltes
     *
     * @param busId
     * @param busLineId
     * @param holdingPointId
     * @param arrival
     * @return histories
     */
    @Override
    public BusHistory addBusHistory(int busId, int busLineId, int holdingPointId, Date arrival) {
        return busHistoryRepository.addBusHistory(busId, busLineId, holdingPointId, arrival);
    }

    @Override
    public int getDelayOfBuslineAtHoldingPoint(int buslineId, int holdingPointId) throws BuslineDoesNotExistsException {
        List<BusHistory> histories = getBusHistoryByLineId(buslineId);
        List<PlannedArrival> plannedArrivals = plannedArrivalService.getPlannedArrivalsByBuslineId(buslineId);

        Collections.sort(plannedArrivals, new PlannedArrivalComparator());
        PlannedArrival plannedArrivalBefore = null;

        for(int i = 0; i < plannedArrivals.size(); i++) {
            if(plannedArrivals.get(i).getHaltestellenID() == holdingPointId && i > 0) {
                plannedArrivalBefore = plannedArrivals.get(i - 1);
                break;
            }
        }

        if(plannedArrivalBefore == null) {
            throw new NullPointerException();
        }

        Collections.sort(histories, new BusHistoryComparator());

        BusHistory stopBefore = null;

        for(BusHistory history : histories) {
            if(history.getHaltestellenId() == plannedArrivalBefore.getHaltestellenID()) {
                stopBefore = history;
                break;
            }
        }

        if(stopBefore == null) {
            throw new NullPointerException();
        }

        return Math.round((stopBefore.getAnkunftszeit().getTime() - plannedArrivalBefore.getArrivalTime().getTime())  / (60 * 1000));
    }
}
