package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.Bus;
import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusAlreadyExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusDoesNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;

import java.util.List;

public interface BusService {

    List<Bus> getAllBuses();

    Bus getBusById(int id) throws BusDoesNotExistException;

    Bus addBus(int busId, int lineId) throws BusAlreadyExistException;

    void removeBus(int id);

    Busline getBuslineOfBus(int busId) throws BusDoesNotExistException, BuslineDoesNotExistsException;
}
