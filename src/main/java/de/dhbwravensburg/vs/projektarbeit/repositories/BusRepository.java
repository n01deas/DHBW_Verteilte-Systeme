package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.Bus;
import de.dhbwravensburg.vs.projektarbeit.entities.Busline;

import java.util.List;

public interface BusRepository {
    List<Bus> getAllBuses();

    Bus getBusById(int id);

    Bus addBus(int busId, int lineId);

    void removeBus(int id);
}
