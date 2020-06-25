package de.dhbwravensburg.vs.projektarbeit.service;

import de.dhbwravensburg.vs.projektarbeit.entities.Busline;
import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineAlreadyExistsException;
import de.dhbwravensburg.vs.projektarbeit.exceptions.BuslineExceptions.BuslineDoesNotExistsException;
import de.dhbwravensburg.vs.projektarbeit.repositories.BuslineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service, zur Abbildung der Interaktionslogik mit der Repository Busline
 */

@Service
public class BuslineServiceImpl implements BuslineService{

    @Autowired
    BuslineRepository buslinerepo;

    /**
     * Methode, welche sämtliche Buslinien zurückgibt, welche in der Repository gespeichert sind
     * @return Gibt die Buslinien in einer "List" mit dem Typ "Buslinie" zurück
     */
    @Override
    public List<Busline> getAllBuslines() {
        return this.buslinerepo.getAllBuslines();
    }

    /**
     * Methode, welche eine Buslinie zurückgibt, die über eine übergebene ID identifiziert wird
     * @param id Gibt die Buslinie an, die zurückgegeben werden soll
     * @return Gibt die ausgewählte Buslinie, in Form eines Objekts, mit dem Typ "Buslinie" zurück
     * @throws BuslineDoesNotExistsException Exception, welche geworfen wird, wenn keine Buslinie zu der ID gefunden wird
     */
    @Override
    public Busline getBuslineById(int id) throws BuslineDoesNotExistsException {
        if(this.buslinerepo.getBuslineById(id) == null){
            throw new BuslineDoesNotExistsException();
        }
        else {
            return this.buslinerepo.getBuslineById(id);
        }
    }

    /**
     * Methode, welche eine neue Buslinie in die Repository einfügt
     * @param lineId Übergabewert für die Buslinien-ID
     * @param title Übergabewert für den Titel der Buslinie
     * @return Gibt die eingefügte Buslinie, in Form eines Objekts, mit dem Typ "Buslinie" zurück
     * @throws BuslineAlreadyExistsException
     */
    @Override
    public Busline addBusline(int lineId, String title) throws BuslineAlreadyExistsException {
        if (this.buslinerepo.checkIfBuslineExists(lineId)){
            throw new BuslineAlreadyExistsException();
        } else{
            this.buslinerepo.addBusline(lineId, title);
        }
        return this.buslinerepo.getBuslineById(lineId);
    }

    /**
     * Methode, welche eine Buslinie aus der Repository löscht, die über eine übergebene ID identifiziert wird
     * @param id Übergabewert für die Buslinien-ID
     */
    @Override
    public void removeBusline(int id) {
        this.buslinerepo.removeBusline(id);
    }

    /**
     * Hier muss noch die Beschreibung rein
     * @param lineId
     * @return
     * @throws BuslineDoesNotExistsException
     */
    @Override
    public List<PlannedArrival> getPlannedArrivalsOfBusline(int lineId) throws BuslineDoesNotExistsException {
        return null;
    }
}
