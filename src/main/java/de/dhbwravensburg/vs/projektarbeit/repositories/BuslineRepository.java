package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;

import java.util.List;

public interface BuslineRepository {
    List<Busline> getAllBuslines();

    Busline getBuslineById(int id);

    Boolean checkIfBuslineExists(int id);

    Busline addBusline(int lineId, String title);

    void removeBusline(int id);
}
