package de.dhbwravensburg.vs.projektarbeit.repositories;

import de.dhbwravensburg.vs.projektarbeit.entities.Bus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BusRepositoryImpl implements BusRepository {
    List<Bus>buses = new ArrayList<>();

    @Override
    public List<Bus> getAllBuses() {
        return buses;
    }

    /** gibt entweder den Bus zurück mit der ID oder null wenn der BUs nicht vorhanden ist
     *
     * @param id
     * @return null oder bus
     */
    @Override
    public Bus getBusById(int id){
        for(Bus bus : buses){
            if(bus.getBusID()==id){
                return bus;
            }
        }

        return null;
    }

    /** fügt einen Bus hinzu
     *
     * @param busId
     * @param lineId
     * @return b
     */
    @Override
    public Bus addBus(int busId, int lineId) {
        Bus b = new Bus(busId, lineId);
        buses.add(b);
        return b;
    }

    /**
     * löscht einen Bus
     * @param id
     */
    @Override
    public void removeBus(int id) {
        for(Bus bus : buses){
            if(bus.getBusID()==id){
                buses.remove(bus);
            }

        }
    }
}
