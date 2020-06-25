package de.dhbwravensburg.vs.projektarbeit.controller;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineAlreadyExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineMismatchException;

import java.util.List;

public interface BuslineController {
    List<Busline> getAllBuslines();

    Busline getSingleBusline(int id);

    Busline addBusline(Busline busline);

    Busline updateBusline(int id, Busline busline);

    void deleteBusline(int id);
}
