package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineAlreadyExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;

import java.util.List;

public interface BuslineService {

    List<Busline> getAllBuslines();

    Busline getBuslineById(int id) throws BuslineDoesNotExistsException;

    Busline addBusline(int lineId, String title) throws BuslineAlreadyExistsException;

    void removeBusline(int id);

    List<PlannedArrival> getPlannedArrivalsOfBusline(int lineId) throws BuslineDoesNotExistsException;
}
