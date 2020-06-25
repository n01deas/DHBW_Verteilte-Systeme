package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointAlreadyExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HoldingPointService {

    /**
     * getAllHoldingPoints
     * Gibt Liste aller Haltestationen zurück.
     *
     * @return Liste mit Haltestationen.
     */
    List<HoldingPoint> getAllHoldingPoints();

    /**
     * getHoldingPointById
     * Gibt eine bestimmte Haltestelle zurück.
     *
     * @param id
     * @return Haltepunkt Objekt
     * @throws HoldingPointNotExistsException
     * @throws HoldingPointNotExistsException
     */
    HoldingPoint getHoldingPointById(int id) throws HoldingPointNotExistsException, HoldingPointNotExistsException;

    /**
     * addHoldingPoint
     * Fügt eine bestimmte Haltestelle hinzu
     *
     * @param holdingPointId
     * @param location
     * @return Haltepunkt Objekt
     * @throws HoldingPointAlreadyExistsException
     * @throws HoldingPointAlreadyExistsException
     */
    HoldingPoint addHoldingPoint(int holdingPointId, String location) throws HoldingPointAlreadyExistsException, HoldingPointAlreadyExistsException;

    /**
     * removeHoldingPoint
     * Entfernt eine Haltestelle.
     *
     * @param id
     * @throws HoldingPointNotExistsException
     */
    void removeHoldingPoint(int id) throws HoldingPointNotExistsException;
}
