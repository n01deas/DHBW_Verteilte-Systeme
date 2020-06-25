package de.dhbwravensburg.vs.projektarbeit.controller;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.exceptions.HoldingPointExceptions.HoldingPointNotExistsException;

import java.util.List;

/**
 * Haltestellen Controller Interface
 */
public interface HoldingPointController {

    /**
     * getArrivals
     * Methode, die geplante Ankünfte der Haltestellen zurück gibt.
     *
     * @param holdingPointId
     * @return Liste mit geplanten Ankünften.
     * @throws HoldingPointNotExistsException
     */
    List<PlannedArrival> getArrivals(int holdingPointId) throws HoldingPointNotExistsException;
}
