package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.Bus;
import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusAlreadyExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BusExceptions.BusDoesNotExistException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.repositories.BusRepository;
import de.dhbwravensburg.vs.projektarbeit.repositories.BuslineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusServiceImpl implements BusService{

    @Autowired
    BusRepository busRepository;

    @Autowired
    BuslineRepository buslineRepository;

    /** alle Busse
     *
     * @return buses
     */
    @Override
    public List<Bus> getAllBuses() {
        return busRepository.getAllBuses();
    }

    /** Bus mit der ID
     *
     * @param id
     * @return bus
     * @throws BusDoesNotExistException
     */
    @Override
    public Bus getBusById(int id) throws BusDoesNotExistException {
        return busRepository.getBusById(id);
    }

    /** Bus wird hinzugefügt
     *
     * @param busId
     * @param lineId
     * @return bus, der hinzugefügt wurde
     * @throws BusAlreadyExistException
     */
    @Override
    public Bus addBus(int busId, int lineId) throws BusAlreadyExistException {
        return busRepository.addBus(busId, lineId);
    }

    /**
     * Bus wird gelöscht
     * @param id
     */
    @Override
    public void removeBus(int id) {
        busRepository.removeBus(id);
    }

    /**
     *  gibt die Linie als Buslineobjekt eines Buses zurück
     * @param busId
     * @return linie
     * @throws BusDoesNotExistException
     * @throws BuslineDoesNotExistsException
     */
    @Override
    public Busline getBuslineOfBus(int busId) throws BusDoesNotExistException, BuslineDoesNotExistsException {
        return buslineRepository.getBuslineById(busRepository.getBusById(busId).getLineID());
    }
}
