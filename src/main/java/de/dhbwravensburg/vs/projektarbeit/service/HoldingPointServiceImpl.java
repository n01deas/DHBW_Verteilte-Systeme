package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.*;
import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import de.dhbwravensburg.vs.projektarbeit.repositories.HoldingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldingPointServiceImpl implements HoldingPointService {

    @Autowired
    BusHistoryService busHistoryService;

    @Autowired
    BuslineService buslineService;

    @Autowired
    HoldingPointRepository holdingPointRepository;


    /**
     * getAllHoldingPoints
     * Gibt Liste aller Haltepunkte zurück.
     *
     * @return Liste mit Haltepunkte
     */
    @Override
    public List<HoldingPoint> getAllHoldingPoints() {

        return this.holdingPointRepository.getAllHoldingPoints();
    }

    /**
     * getHoldingPointById
     * Gibt bestimmten Haltepunkt zurück.
     *
     * @param id
     * @return Haltepunkt Objekt
     * @throws HoldingPointNotExistsException
     */
    @Override
    public HoldingPoint getHoldingPointById(int id) throws HoldingPointNotExistsException {

        for(HoldingPoint holdingPoint: getAllHoldingPoints()){
            if(holdingPoint.getHaltestelleId() == id){
                return holdingPoint;
            }
        }
        throw new HoldingPointNotExistsException();
    }

    /**
     * addHoldingPoint
     * Fügt eine neue Haltestation hinzu.
     *
     * @param holdingPointId
     * @param location
     * @return
     * @throws HoldingPointAlreadyExistsException
     */
    @Override
    public HoldingPoint addHoldingPoint(int holdingPointId, String location) throws HoldingPointAlreadyExistsException {
       return holdingPointRepository.addHoldingPoint(holdingPointId,location );
    }

    /**
     * removeHoldingPoint
     * Entfernt eine Haltestation.
     *
     * @param id
     * @throws HoldingPointNotExistsException
     */
    @Override
    public void removeHoldingPoint(int id) throws HoldingPointNotExistsException {
        for(HoldingPoint holdingPoint : getAllHoldingPoints()){
            if(holdingPoint.getHaltestelleId() == id){
                holdingPointRepository.removeHoldingPoint(id);
            }
        }
        throw new HoldingPointNotExistsException();
    }
}
