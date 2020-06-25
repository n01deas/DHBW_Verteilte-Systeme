package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HoldingPointRepositoryImpl implements HoldingPointRepository{

    List<HoldingPoint> holdingPointList = new ArrayList<>();

    /**
     * getAllHoldingPoints
     * Gibt eine Liste aller Haltepunkte zurück.
     *
     * @return Liste mit Haltepunkte
     */
    @Override
    public List<HoldingPoint> getAllHoldingPoints() {
        return holdingPointList;
    }

    /**
     * getHoldingPointById
     * Gibt bestimmten Haltepunkt zurück.
     *
     * @param id
     * @return Haltepunkt Objekt
     */
    @Override
    public HoldingPoint getHoldingPointById(int id) {

        for(HoldingPoint holdingPoint: holdingPointList){
            if(holdingPoint.getHaltestelleId() == id) {
                return holdingPoint;
            }
        }
        return null;
    }

    /**
     * addHoldingPoint
     * Fügt Haltepunk hinzu
     *
     * @param holdingPointId
     * @param location
     * @return Haltepunkt Objekt
     */
    @Override
    public HoldingPoint addHoldingPoint(int holdingPointId, String location) {

        HoldingPoint holdingPoint = new HoldingPoint(holdingPointId, location);
        holdingPointList.add(holdingPoint);
        return holdingPoint;

    }

    /**
     * removeHoldingPoint
     * Entfernt einen Haltepunkt.
     *
     * @param id
     */
    @Override
    public void removeHoldingPoint(int id) {
        for(int i = 0; i < holdingPointList.size(); i++) {
            if(holdingPointList.get(i).getHaltestelleId() == id) {
                holdingPointList.remove(i);
            }
        }
    }
}
