package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;

public interface AsyncBusHistoryService {
    void recieveMessage(BusHistory busHistory);
}
