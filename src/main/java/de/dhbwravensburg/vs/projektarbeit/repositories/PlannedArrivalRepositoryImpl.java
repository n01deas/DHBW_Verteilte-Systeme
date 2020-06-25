package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Repository, in dem alle geplanten Ankünfte gespeichert und mit einer ID identifiziert werden können.
 */
@Repository
public class PlannedArrivalRepositoryImpl implements PlannedArrivalRepository {

    public List<PlannedArrival> plannedArrivals = new ArrayList<>();
    @Override
    public List<PlannedArrival> getAllPlannedArrivals() {
        return plannedArrivals;
    }

    @Override
    public PlannedArrival getPlannedArrivalById(int id) {
        for (PlannedArrival plannedArrival : plannedArrivals) {
            if (plannedArrival.getArrivalID().equals(id)) {
                return plannedArrival;
            }
        }
        return null;
    }

    @Override
    public PlannedArrival addPlannedArrival(int arrivalId, Date arrivalTime, int holdingPointId, int buslineId) {
        PlannedArrival plannedArrival = new PlannedArrival(arrivalId, arrivalTime, holdingPointId, buslineId);
        plannedArrivals.add(plannedArrival);
        return plannedArrival;
    }

    @Override
    public List<PlannedArrival> getPlannedArrivalsByHoldingPointId(int holdingPointId) {
        List<PlannedArrival> arrivalsByHoldingPointId = new ArrayList<>();
        for(PlannedArrival plannedArrival : plannedArrivals) {
            if(plannedArrival.getHaltestellenID() == holdingPointId) {
                arrivalsByHoldingPointId.add(plannedArrival);
            }
        }
        return arrivalsByHoldingPointId;
    }

    @Override
    public List<PlannedArrival> getPlannedArrivalsByBuslineId(int buslineId) {
        List<PlannedArrival> arrivalsByBuslineId = new ArrayList<>();
        for(PlannedArrival plannedArrival : plannedArrivals) {
            if(plannedArrival.getBuslineID() == buslineId) {
                arrivalsByBuslineId.add(plannedArrival);
            }
        }
        return arrivalsByBuslineId;
    }

    @Override
    public List<PlannedArrival> getPlannedArrivalsByHoldingPointIdAndBuslineId(int holdingPointId, int buslineId) {
        List<PlannedArrival> arrivalsBothIds = new ArrayList<>();
        for(PlannedArrival plannedArrival : plannedArrivals) {
            if(plannedArrival.getHaltestellenID() == holdingPointId & plannedArrival.getBuslineID() == buslineId) {
                arrivalsBothIds.add(plannedArrival);
            }
        }
        return arrivalsBothIds;
    }

    @Override
    public void removePlannedArrival(int id) {
        for (PlannedArrival plannedArrival : plannedArrivals) {
            if(plannedArrival.getArrivalID().equals(id)) {
                plannedArrivals.remove(plannedArrival);
                return;
            }
        }
        return;

    }
}
