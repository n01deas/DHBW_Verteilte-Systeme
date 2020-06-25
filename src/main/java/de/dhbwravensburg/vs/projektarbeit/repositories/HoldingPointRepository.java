package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.HoldingPoint;

import java.util.List;

public interface HoldingPointRepository {

    /**
     * getAllHoldingPoints
     * Gibt Liste mit Haltelstellen zurück.
     *
     * @return Liste der Haltestellen.
     */
    List<HoldingPoint> getAllHoldingPoints();

    /**
     * getHoldingPointById
     * Gibt bestimmte Haltestelle zurück.
     *
     * @param id
     * @return Gibt ein Haltestellen Objekt zurück.
     */
    HoldingPoint getHoldingPointById(int id);

    /**
     * addHoldingPoint
     * Fügt eine neue Haltestelle hinzu.
     *
     * @param holdingPointId
     * @param location
     * @return Gibt ein Haltestellen Objekt zurück.
     */
    HoldingPoint addHoldingPoint(int holdingPointId, String location);

    /**
     * removeHoldingPoint
     * Entfernt eine Haltestelle.
     *
     * @param id
     */
    void removeHoldingPoint(int id);
}

