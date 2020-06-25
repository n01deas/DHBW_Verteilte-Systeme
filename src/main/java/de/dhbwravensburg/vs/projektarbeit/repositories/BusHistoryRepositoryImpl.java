package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.Bus;
import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BusHistoryRepositoryImpl implements BusHistoryRepository{

    List<BusHistory> busHistories = new ArrayList<>();

    @Override
    public List<BusHistory> getAllBusHistories() {
        return busHistories;
    }


    /** gibt eine Liste von BusHistories zurück.
     * Das sind die Halte con einer Linie
     *
     * @param id
     * @return histories
     */
    @Override
    public List<BusHistory> getBusHistoryByLineId(int id) {
        List<BusHistory> histories = new ArrayList<>();
        for(BusHistory busHistory : busHistories){
            if(busHistory.getBuslinie()==id){
                histories.add(busHistory);
            }
        }

        return histories;
    }

    /** Das gibt die Halte also die BusHistories von dem Bus mit der ID zurück
     *
     * @param id
     * @return histories
     */
    @Override
    public List<BusHistory> getBusHistoryByBusId(int id) {
        List<BusHistory> histories = new ArrayList<>();
        for(BusHistory busHistory : busHistories){
            if(busHistory.getBusId()==id){
                histories.add(busHistory);
            }
        }

        return histories;
    }


    /** gibt die Halte an der Haltestelle zurück
     *
     * @param id
     * @return histories
     */
    @Override
    public List<BusHistory> getBusHistoryByHoldingPointId(int id) {
        List<BusHistory> histories = new ArrayList<>();
        for(BusHistory busHistory : busHistories){
            if(busHistory.getHaltestellenId()==id){
                histories.add(busHistory);
            }
        }

        return histories;

    }

    /** gibt Halte vn einer bestimmten Linie an dieser Haltestelle aus
     *
     * @param busLineId
     * @param holdingPointId
     * @return histories
     */
    @Override
    public List<BusHistory> getBusHistoryByLineIdAndHoldingPoint(int busLineId, int holdingPointId) {
        List<BusHistory> histories = new ArrayList<>();
        for(BusHistory busHistory : busHistories){
            if(busHistory.getBuslinie()==busLineId && busHistory.getHaltestellenId()==holdingPointId){
                histories.add(busHistory);
            }
        }

        return histories;
    }

    /** gibt den neu erstellten Halt aus.
     *
     * @param busId
     * @param busLineId
     * @param holdingPointId
     * @param arrival
     * @return busHistory
     */
    @Override
    public BusHistory addBusHistory(int busId, int busLineId, int holdingPointId, Date arrival) {
        BusHistory busHistory = new BusHistory(busId,busLineId,holdingPointId,arrival);
        busHistories.add(busHistory);
        return busHistory;
    }
}
